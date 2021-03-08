package sk.euba.tajj.cviko.sort;

import sk.euba.tajj.cviko.configuration.CommandLineConfiguration;
import sk.euba.tajj.cviko.tracker.DisabledTimeTracker;
import sk.euba.tajj.cviko.tracker.TimeTracker;
import sk.euba.tajj.cviko.tracker.TimeTrackerImpl;

public class SortFactory {

    public static Sort getSortingImplementation (TypeOfSort typeOfSort){
        CommandLineConfiguration configuration = CommandLineConfiguration.getInstance();
        TimeTracker tracker = configuration.isTrackTime() ? new TimeTrackerImpl() : new DisabledTimeTracker();
        switch (typeOfSort){
            case BUBBLE_SORT: return new BubbleSort(tracker, configuration.isReverse());
            case MERGE_SORT: return new MergeSort(tracker, configuration.isReverse());
            case QUICK_SORT: return new QuickSort(tracker, configuration.isReverse());
            case INSERTION_SORT: return new InsertionSort(tracker, configuration.isReverse());
            default: return null;
        }
    }
}
