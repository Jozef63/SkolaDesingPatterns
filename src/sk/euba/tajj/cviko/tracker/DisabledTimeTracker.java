package sk.euba.tajj.cviko.tracker;

import java.time.Duration;

public class DisabledTimeTracker implements TimeTracker{

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public Duration getDuration() {
        return null;
    }
}
