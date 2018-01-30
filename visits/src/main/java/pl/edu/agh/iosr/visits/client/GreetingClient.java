package pl.edu.agh.iosr.visits.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.agh.iosr.visits.beans.VisitsRequest;
import pl.edu.agh.iosr.visits.beans.VisitsResponse;

@FeignClient(name="GreetingApplication")
public interface GreetingClient {
    @RequestMapping(value = "/visits", method = RequestMethod.POST)
    VisitsResponse visits(VisitsRequest request);
}
