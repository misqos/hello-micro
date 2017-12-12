package pl.edu.agh.iosr.hello.beans;

import java.util.Objects;

public class GreetingResponse {
    private String message;
    private long visits;

    public GreetingResponse(final String message, final long visits) {
        this.message = message;
        this.visits = visits;
    }

    public String getMessage() {
        return message;
    }

    public void setVisits(long visits) {
        this.visits = visits;
    }

    public long getVisits() {
        return visits;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GreetingResponse that = (GreetingResponse) o;
        return visits == that.visits &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, visits);
    }

    @Override
    public String toString() {
        return "GreetingResponse{" +
                "message='" + message + '\'' +
                ", visits=" + visits +
                '}';
    }
}
