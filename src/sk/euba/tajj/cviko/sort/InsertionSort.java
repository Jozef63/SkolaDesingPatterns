package sk.euba.tajj.cviko.sort;

import sk.euba.tajj.cviko.tracker.TimeTracker;

public class InsertionSort implements Sort {

    private final TimeTracker timeTracker;
    private final boolean reverse;

    public InsertionSort(TimeTracker timeTracker, boolean reverse){
        this.timeTracker = timeTracker;
        this.reverse = reverse;
    }
    public InsertionSort(TimeTracker timeTracker){
        this(timeTracker, false);
    }

    @Override
    public int[] sort(int [] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
