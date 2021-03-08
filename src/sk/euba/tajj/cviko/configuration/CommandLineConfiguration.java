package sk.euba.tajj.cviko.configuration;

import sk.euba.tajj.cviko.generator.RandomNumberGenerator;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Map;

// Singleton
public final class CommandLineConfiguration {

    private final boolean reverse;
    private final boolean trackTime;
    private final int [] arrToSort;
    private final ChronoUnit unit;

    private static CommandLineConfiguration instance = null;

    private CommandLineConfiguration(boolean reverse, boolean trackTime, int [] arrToSort, ChronoUnit unit){
        this.reverse = reverse;
        this.trackTime = trackTime;
        this.arrToSort = arrToSort;
        this.unit = unit;
    }

    private CommandLineConfiguration(){
        this(false, true, null, ChronoUnit.SECONDS);
    }

    public static CommandLineConfiguration initWithArgs(Map<String, String> args) {
        if (instance == null) {
            boolean reverse = Boolean.valueOf(args.get("reverse"));
            boolean trackTime = Boolean.valueOf(args.get("trackTime"));
            String textPola = args.get("pole");
            ChronoUnit unit = ChronoUnit.valueOf(args.get("unit"));
            int [] arrToSort = textPola.contains(",") ?
                    Arrays.stream(textPola.split(",")).mapToInt(Integer::parseInt).toArray() :
                    RandomNumberGenerator.generate(Integer.valueOf(textPola));
            instance = new CommandLineConfiguration(reverse, trackTime, arrToSort, unit);
        }
        return instance;
    }
    public static CommandLineConfiguration getInstance(){
        return instance == null ? new CommandLineConfiguration() : instance;
    }

    public boolean isReverse() {

        return this.reverse;
    }

    public boolean isTrackTime() {

        return this.trackTime;
    }

    public int[] getArrToSort() {

        return this.arrToSort;
    }

    public ChronoUnit getUnit() {
        return this.unit;
    }
}
