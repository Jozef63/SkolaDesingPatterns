package sk.euba.tajj.cviko.tracker;

import java.time.Duration;
import java.time.Instant;

public class TimeTrackerImpl implements TimeTracker {

    private Instant start;
    private Instant stop;

    @Override
    public void start() {
        start = Instant.now();
    }

    @Override
    public void stop() {
        stop = Instant.now();
    }

    @Override
    public Duration getDuration() {
        return start == null || stop == null ? null : Duration.between(start, stop);
    }
}
