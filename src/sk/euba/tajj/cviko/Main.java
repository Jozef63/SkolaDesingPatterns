package sk.euba.tajj.cviko;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String [] args){
        BestPractices program = new BestPractices();
        program.run();

        List<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Skoda");
        cars.add("Audi");

//        for (String car : cars){
//            if (car.startsWith("B")){
//                System.out.println(car);
//            }
//        }
        cars.stream()
                .filter(car -> car.startsWith("B"))
                .forEach(System.out::println);
    }
}
