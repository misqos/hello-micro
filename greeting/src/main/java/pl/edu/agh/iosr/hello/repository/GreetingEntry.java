package pl.edu.agh.iosr.hello.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.edu.agh.iosr.hello.beans.GreetingResponse;

@Document
public class GreetingEntry {
    private @Id String name;
    private long count;

    public GreetingEntry(){}

    public GreetingEntry(final String name, final long count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "GreetingEntry{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
