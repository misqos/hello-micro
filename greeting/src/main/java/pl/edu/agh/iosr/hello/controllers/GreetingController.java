package pl.edu.agh.iosr.hello.controllers;

import pl.edu.agh.iosr.hello.beans.GreetingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.iosr.hello.beans.VisitsRequest;
import pl.edu.agh.iosr.hello.beans.VisitsResponse;
import pl.edu.agh.iosr.hello.repository.GreetingEntry;
import pl.edu.agh.iosr.hello.repository.GreetingRepository;

@RestController
public class GreetingController {
    private static final String TEMPLATE = "Hello, %s!";

    @Autowired
    private GreetingRepository greetingRepository;

    @RequestMapping(value = "/greeting")
    public GreetingResponse greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        GreetingEntry increment = greetingRepository.increment(name);
        return new GreetingResponse(String.format(TEMPLATE, increment.getName()), increment.getCount());
    }

    @RequestMapping(value = "/visits", method = RequestMethod.POST)
    public VisitsResponse visits(VisitsRequest request) {
        return new VisitsResponse(greetingRepository.findOne(request.getName()).getCount());
    }
}
