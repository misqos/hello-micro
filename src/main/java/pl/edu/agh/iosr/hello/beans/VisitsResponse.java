package pl.edu.agh.iosr.hello.beans;

import java.util.Objects;

public class VisitsResponse {
    private final long visits;

    public VisitsResponse(long visits) {
        this.visits = visits;
    }

    public long getVisits() {
        return visits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitsResponse that = (VisitsResponse) o;
        return visits == that.visits;
    }

    @Override
    public int hashCode() {

        return Objects.hash(visits);
    }

    @Override
    public String toString() {
        return "VisitsResponse{" +
                "visits=" + visits +
                '}';
    }
}
