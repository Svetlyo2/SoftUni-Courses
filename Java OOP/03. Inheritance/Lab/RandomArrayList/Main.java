package RandomArrayList;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        RandomArrayList<Integer> randomArrayList = new RandomArrayList<>();
        RandomArrayList randomArrayList = new RandomArrayList();
        try {
            randomArrayList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
    }

}
