package sk.euba.tajj.cviko.sort;

import sk.euba.tajj.cviko.tracker.TimeTracker;

public class BubbleSort implements Sort {

    private final TimeTracker timeTracker;
    private final boolean reverse;

    public BubbleSort(TimeTracker timeTracker, boolean reverse) {
        this.timeTracker = timeTracker;
        this.reverse = reverse;
    }
    public BubbleSort(TimeTracker timeTracker) {
        this(timeTracker, false);
    }

    @Override
    public int[] sort(int [] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
