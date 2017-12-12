package pl.edu.agh.iosr.visits.beans;

import java.util.Objects;

public class CountResponse {
    private final long count;

    public CountResponse(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountResponse that = (CountResponse) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        return "CountResponse{" +
                "count=" + count +
                '}';
    }
}
