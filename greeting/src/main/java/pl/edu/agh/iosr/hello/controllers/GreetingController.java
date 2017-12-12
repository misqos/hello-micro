package pl.edu.agh.iosr.hello.controllers;

import org.springframework.web.bind.annotation.*;
import pl.edu.agh.iosr.hello.beans.GreetingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.iosr.hello.beans.VisitsRequest;
import pl.edu.agh.iosr.hello.beans.VisitsResponse;
import pl.edu.agh.iosr.hello.repository.GreetingEntry;
import pl.edu.agh.iosr.hello.repository.GreetingRepository;

import java.util.Optional;

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
    public VisitsResponse visits(@RequestBody VisitsRequest request) {
        return new VisitsResponse(
                Optional.ofNullable(greetingRepository.findOne(request.getName()))
                        .map(GreetingEntry::getCount)
                        .orElse(0L)
        );
    }
}
