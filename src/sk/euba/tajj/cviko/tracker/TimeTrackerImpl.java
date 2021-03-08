package sk.euba.tajj.cviko.tracker;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class TimeTrackerImpl implements TimeTracker {

    private Instant start;
    private Instant stop;
    private final ChronoUnit unit;

    public TimeTrackerImpl(ChronoUnit unit){
        this.unit = unit;
    }
    @Override
    public void start() {
        start = Instant.now();
    }

    @Override
    public void stop() {
        stop = Instant.now();
    }

    @Override
    public void printDuration () {
         if(start == null || stop == null) {
             System.out.println("Duration not meassured correctly");
        } else {
             Duration duration = Duration.between(start, stop);
             switch (unit){
                 case MILLIS:
                     System.out.println("trvanie: " + duration.toMillis() + " Mili Sekund");
                     break;
                 case NANOS:
                     System.out.println("trvanie: " + duration.toNanos() + " Nano Sekund");
                     break;
                 default:
                     System.out.println("trvanie: " + duration.toSeconds() + " Sekund");
                     break;
             }
        }
    }
}
