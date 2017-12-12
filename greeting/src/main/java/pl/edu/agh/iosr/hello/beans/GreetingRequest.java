package pl.edu.agh.iosr.hello.beans;

public class GreetingRequest {
    private String name;

    public GreetingRequest(String name) {
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

        GreetingRequest greetingRequest = (GreetingRequest) o;

        return name != null ? name.equals(greetingRequest.name) : greetingRequest.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "GreetingRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
