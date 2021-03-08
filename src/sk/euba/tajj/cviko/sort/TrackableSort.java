package sk.euba.tajj.cviko.sort;

import sk.euba.tajj.cviko.tracker.TimeTracker;

public class TrackableSort implements Sort{

    private final Sort sort;
    private final TimeTracker timeTracker;

    public TrackableSort(Sort sort, TimeTracker timeTracker){
        this.sort = sort;
        this.timeTracker = timeTracker;
    }

    @Override
    public int[] sort(int[] arrToSort) {
        timeTracker.start();
        sort.sort(arrToSort);
        timeTracker.stop();
        System.out.println("zoradovanie trvalo: " + timeTracker.getDuration().toMillis() + " milisekund ");
        return arrToSort;
    }
}
