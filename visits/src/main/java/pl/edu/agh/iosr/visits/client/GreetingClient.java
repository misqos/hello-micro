package pl.edu.agh.iosr.visits.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.agh.iosr.hello.beans.VisitsRequest;
import pl.edu.agh.iosr.hello.beans.VisitsResponse;

@FeignClient(name="GreetingApplication")
public interface GreetingClient {
    @RequestMapping(value = "/visits", method = RequestMethod.POST)
    VisitsResponse visits(VisitsRequest request);
}
