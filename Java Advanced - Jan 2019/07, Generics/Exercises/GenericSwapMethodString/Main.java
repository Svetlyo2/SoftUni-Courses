package GenericSwapMethodString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<BoxString<String>> list = new ArrayList<>();
        //List<BoxString<Integer>> listOfIntegers=new ArrayList<>();

        while (n-- > 0) {
            String line = scanner.nextLine();
            BoxString<String> boxString = new BoxString<>(line);
            list.add(boxString);
//            try {
//                int number=Integer.parseInt(line);
//                boxString = new BoxString<>(number);
//                listOfIntegers.add(boxString);
//            } catch (Exception e){
//                boxString=new BoxString<>(line);
//                list.add(boxString);
//            }
        }
        int[] indexes = Arrays.stream(scanner.nextLine()
                        .split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();
        swapValues(list, indexes[0], indexes[1]);
        for (BoxString<String> box : list) {
            System.out.println(box.toString());
        }
        //if (listOfIntegers.isEmpty()){
//            swapValues(list,indexes[0],indexes[1]);
//            for (BoxString<String> box : list) {
//                System.out.println(box.toString());
//            }
//        } else {
//            swapValues(listOfIntegers,indexes[0],indexes[1]);
//            for (BoxString<Integer> box : listOfIntegers) {
//                System.out.println(box.toString());
//            }
//        }
    }

    public static <T> void swapValues(List<T> list, int firstIndex, int secondIndex) {
        T temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);
    }
}
