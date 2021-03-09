package sk.euba.tajj.cviko.sort;

import sk.euba.tajj.cviko.tracker.TimeTracker;

public class SortTracker implements Sort {

    private final Sort sort;
    private final TimeTracker timeTracker;

    public SortTracker(Sort sort, TimeTracker timeTracker){
        this.sort = sort;
        this.timeTracker = timeTracker;
    }

    @Override
    public int[] sort(int[] arrToSort) {
        timeTracker.start();
        sort.sort(arrToSort);
        timeTracker.stop();
        timeTracker.printDuration();
        return arrToSort;
    }
}
