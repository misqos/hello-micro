package pl.edu.agh.iosr.hello.repository;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.edu.agh.iosr.hello.beans.GreetingResponse;

import java.util.Objects;
import java.util.Optional;

public interface GreetingRepository extends MongoRepository<GreetingEntry, String> {
    default GreetingEntry increment(final String name) {
        return save(Optional.ofNullable(findOne(name))
                .map(gr -> new GreetingEntry(name, gr.getCount() + 1))
                .orElse(new GreetingEntry(name, 1)));
    }
}
