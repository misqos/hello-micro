package pl.edu.agh.iosr.hello.beans;

import java.util.Objects;

public class VisitsRequest {
    private final String name;

    public VisitsRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitsRequest that = (VisitsRequest) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "VisitsRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
