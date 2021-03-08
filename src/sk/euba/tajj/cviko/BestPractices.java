package sk.euba.tajj.cviko;

import sk.euba.tajj.cviko.configuration.CommandLineConfiguration;
import sk.euba.tajj.cviko.generator.RandomNumberGenerator;
import sk.euba.tajj.cviko.io.IoUtility;
import sk.euba.tajj.cviko.sort.Sort;
import sk.euba.tajj.cviko.sort.SortFactory;
import sk.euba.tajj.cviko.sort.TrackableSort;
import sk.euba.tajj.cviko.sort.TypeOfSort;
import sk.euba.tajj.cviko.tracker.TimeTrackerImpl;

public class BestPractices {

    public void run() {
        int [] arr = CommandLineConfiguration.initWithArgs(IoUtility.getUserConfiguration()).getArrToSort();
        Sort sort = SortFactory.getSortingImplementation(TypeOfSort.valueOf(IoUtility.getSortType()));
        TrackableSort trackableSort = new TrackableSort(sort, new TimeTrackerImpl());
        arr = RandomNumberGenerator.generate(100000);
        System.out.println("zoradujem pole: " + IoUtility.arrayToString(arr) + "metodou: " + sort.getClass().getSimpleName());
        arr = trackableSort.sort(arr);
        System.out.println("zoradene pole: " + IoUtility.arrayToString(arr));
    }

}
