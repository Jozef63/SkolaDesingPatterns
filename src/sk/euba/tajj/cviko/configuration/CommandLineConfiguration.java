package sk.euba.tajj.cviko.configuration;

import java.util.Arrays;

// Singleton
public final class CommandLineConfiguration {

    private final boolean reverse;
    private final boolean trackTime;
    private final int [] arrToSort;

    private static CommandLineConfiguration instance = null;
    private CommandLineConfiguration(boolean reverse, boolean trackTime, int [] arrToSort){
        this.reverse = reverse;
        this.trackTime = trackTime;
        this.arrToSort = arrToSort;
    }

    private CommandLineConfiguration(){
        this(false, true, new int[]{1, 5, 6, 8, 7, 4, 9, 15, 6});
    }

    public static CommandLineConfiguration initWithArgs(String [] args) {
        int[] arrToSort = args.length > 0 ?
                Arrays.stream(args[0].split(",")).mapToInt(Integer::parseInt).toArray() :
                new int[]{1, 5, 6, 8, 7, 4, 9, 15, 6};
        boolean reverse = args.length > 1 ? Boolean.parseBoolean(args[1]) : false;
        boolean trackTime = args.length > 2 ? Boolean.parseBoolean(args[2]) : true;

        return new CommandLineConfiguration(reverse, trackTime, arrToSort);
    }
    public static CommandLineConfiguration getInstance(){
        return instance == null ? new CommandLineConfiguration() : instance;
    }

    public boolean isReverse() {
        return reverse;
    }

    public boolean isTrackTime() {
        return trackTime;
    }

    public int[] getArrToSort() {
        return arrToSort;
    }
}
