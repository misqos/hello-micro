package pl.edu.agh.iosr.visits.beans;

import java.util.Objects;

public class VisitsRequest {
    private String name;

    public VisitsRequest() {
    }

    public VisitsRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
