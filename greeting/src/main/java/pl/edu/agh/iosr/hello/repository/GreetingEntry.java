package pl.edu.agh.iosr.hello.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class GreetingEntry {
    private final @Id String name;
    private final long count;

    public GreetingEntry(final String name, final long count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public long getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "GreetingEntry{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
