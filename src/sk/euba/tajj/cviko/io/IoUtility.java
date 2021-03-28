package sk.euba.tajj.cviko.io;

import sk.euba.tajj.cviko.configuration.CommandLineConfiguration;
import sk.euba.tajj.cviko.sort.Sort;

import java.util.*;
import java.util.stream.IntStream;

public class IoUtility {
    private static final Scanner scanner = new Scanner(System.in);
    public static Map<String, String> getUserConfiguration() {

        Map<String, String> args = new HashMap<>();
        System.out.println("zadajte prosim pole ktore chcete zoradit (cele cisla oddelene ciarkou) \r\n" +
                "ak zadate iba jednu hodnotu bude vygenerovane nahodne pole o dlzke danej hodnoty: ");
        args.put("pole", scanner.nextLine());
        System.out.println("zadajte prosim ci chcete pole zoradit zostupne (true/false): ");
        System.out.println("");
        args.put("reverse", scanner.nextLine());
        System.out.println("zadajte prosim ci chcete merat cas (true/false) : ");
        args.put("trackTime", scanner.nextLine());

        if (Boolean.valueOf(args.get("trackTime"))){
            System.out.println("v akej jednotke si prajete merat cas (SECONDS, MILLIS, NANOS): ");
            args.put("unit", scanner.nextLine());
        }


        return args;
    }

    public static String getSortType(){
        System.out.println("akou metodou chcete zoradit pole? (BUBBLE_SORT, MERGE_SORT," +
                "INSERTION_SORT, QUICK_SORT, SELECTION_SORT) :");
        return scanner.nextLine();
    }

    public static <T> String arrayToString(T[] arr) {
        StringBuilder sb = new StringBuilder();
        for (T i : arr){
            sb.append(i);
            sb.append(",");
        }
        sb.substring(sb.length() -1);
        return sb.toString();
    }

    private static String arrayToString(int [] arr){
        return arrayToString(IntStream.of( arr ).boxed().toArray( Integer[]::new ));
    }

    public static void printResults(Sort sort, int[] arr) {
        System.out.println("zoradujem pole: " + IoUtility.arrayToString(arr) + "metodou: " + sort.getClass().getSimpleName());
        arr = sort.sort(arr);
        System.out.println("zoradene pole: " + IoUtility.arrayToString(arr));
    }

    public static int[] getInputArray() {
        return  CommandLineConfiguration.getInstance().getArrToSort();
    }
}
