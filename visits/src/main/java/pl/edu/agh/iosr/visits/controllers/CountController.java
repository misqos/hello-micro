package pl.edu.agh.iosr.visits.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.iosr.hello.beans.VisitsRequest;
import pl.edu.agh.iosr.hello.beans.VisitsResponse;
import pl.edu.agh.iosr.visits.beans.CountResponse;
import pl.edu.agh.iosr.visits.client.GreetingClient;

@RestController
public class CountController {

    @Autowired
    private GreetingClient greetingClient;

    @RequestMapping("/count")
    public CountResponse getCount(@RequestParam(value = "name", defaultValue = "World") String name) {
        VisitsRequest request = new VisitsRequest("World");
        VisitsResponse response = greetingClient.visits(request);
        return new CountResponse(response.getVisits());
    }
}
