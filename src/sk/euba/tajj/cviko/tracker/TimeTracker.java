package sk.euba.tajj.cviko.tracker;

import java.time.Duration;

public interface TimeTracker {
    void start();
    void stop();
    Duration getDuration();
}
