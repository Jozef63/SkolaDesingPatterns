package sk.euba.tajj.cviko.tracker;

import java.time.temporal.ChronoUnit;

public class DisabledTimeTracker implements TimeTracker{

    @Override
    public void start() { }

    @Override
    public void stop() { }

    @Override
    public void printDuration() { }

}
