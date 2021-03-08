package sk.euba.tajj.cviko.sort;

import sk.euba.tajj.cviko.configuration.CommandLineConfiguration;
import sk.euba.tajj.cviko.tracker.TimeTrackerImpl;

public class SortFactory {

    public static Sort getSortingImplementation (TypeOfSort typeOfSort){
        CommandLineConfiguration configuration = CommandLineConfiguration.getInstance();
        Sort sort = getSortByType(typeOfSort);
        if (configuration.isTrackTime()){
            sort = new SortTracker(sort, new TimeTrackerImpl(configuration.getUnit()));
        }
        return sort;
    }

    private static Sort getSortByType(TypeOfSort typeOfSort) {
        switch (typeOfSort){
            case BUBBLE_SORT: return new BubbleSort();
            case MERGE_SORT: return new MergeSort();
            case QUICK_SORT: return new QuickSort();
            case INSERTION_SORT: return new InsertionSort();
            case SELECTION_SORT: return (arr -> {
                int n = arr.length;
                for (int i = 0; i < n - 1; i++) {
                    int min_idx = i;
                    for (int j = i + 1; j < n; j++) {
                        if (arr[j] < arr[min_idx])
                            min_idx = j;
                        int temp = arr[min_idx];
                        arr[min_idx] = arr[i];
                        arr[i] = temp;
                    }
                }
                return arr;
            });
            default: return null;
        }
    }
}
