package sk.euba.tajj.cviko;

import sk.euba.tajj.cviko.configuration.CommandLineConfiguration;
import sk.euba.tajj.cviko.io.IoUtility;
import sk.euba.tajj.cviko.sort.Sort;
import sk.euba.tajj.cviko.sort.SortFactory;
import sk.euba.tajj.cviko.sort.TypeOfSort;

import static sk.euba.tajj.cviko.io.IoUtility.printResults;


public class DesignExample {

    public void run() {
        CommandLineConfiguration.initWithArgs(IoUtility.getUserConfiguration());
        Sort sort = null;

        try {
            sort = SortFactory.getSortingImplementation(TypeOfSort.valueOf(IoUtility.getSortType()));
        } catch (IllegalArgumentException ex){
            System.err.println("zadali ste nespravny typ zoradovania !");
            System.err.println("dostupne typy su : " + IoUtility.arrayToString(TypeOfSort.values()));
            throw new IllegalArgumentException("Nespravny typ zoradovania !");
        }
        int arr[] = IoUtility.getInputArray();
        printResults(sort, arr);
    }
}
