package sk.euba.tajj.cviko.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IoUtility {
    private static final Scanner scanner = new Scanner(System.in);
    public static String [] getUserConfiguration() {
        List<String> args = new ArrayList<>();
        System.out.println("zadajte prosim pole ktore chcete zoradit (cele cisla oddelene ciarkou) :");
        args.add(scanner.nextLine());
        System.out.println("zadajte prosim ci chcete pole zoradit zostupne (true/false) : ");
        args.add(scanner.nextLine());
        System.out.println("zadajte prosim ci chcete merat cas (true/false) : ");
        args.add(scanner.nextLine());
        return args.toArray(new String [0]);
    }

    public static String getSortType(){
        System.out.println("akou metodou chcete zoradit pole? (BUBBLE_SORT, MERGE_SORT," +
                "INSERTION_SORT, QUICK_SORT) :");
        return scanner.nextLine();
    }

    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr){
            sb.append(i);
            sb.append(",");
        }
        sb.substring(sb.length() -1);
        return sb.toString();
    }
}
