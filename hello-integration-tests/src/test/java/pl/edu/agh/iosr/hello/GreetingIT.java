package pl.edu.agh.iosr.hello;

import com.palantir.docker.compose.DockerComposeRule;
import com.palantir.docker.compose.connection.waiting.HealthChecks;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.http.client.utils.URIBuilder;
import org.awaitility.Duration;
import org.junit.ClassRule;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.awaitility.Awaitility.given;

public class GreetingIT {
    @ClassRule
    public static DockerComposeRule docker = DockerComposeRule.builder()
            .file("../consul.yml")
            .waitingForService("mongodb", HealthChecks.toHaveAllPortsOpen())
            .waitingForService("consul", HealthChecks.toHaveAllPortsOpen())
            .waitingForService("greeting", HealthChecks.toHaveAllPortsOpen())
            .waitingForService("visits", HealthChecks.toHaveAllPortsOpen())
            .build();

    @Test
    public void simpleTest() {
        given().ignoreExceptions().await().atMost(Duration.ONE_MINUTE).untilAsserted(() ->
                assertThat(new OkHttpClient.Builder().build().newCall(
                        new Request.Builder()
                                .url(HttpUrl.parse(
                                        new URIBuilder()
                                                .setScheme("http")
                                                .setHost("greeting")
                                                .setPort(8080).toString()
                                        ).newBuilder().addPathSegments("greeting").build()
                                ).get().build()
                ).execute().code()).isEqualTo(200));
    }
}
