package sk.euba.tajj.cviko.generator;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {
    public static int [] generate(int n){
        System.out.println("Generujem nahodnych " + n + "cisiel.");
        int [] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i]= ThreadLocalRandom.current().nextInt(10000);
        }
        return arr;
    }
}
