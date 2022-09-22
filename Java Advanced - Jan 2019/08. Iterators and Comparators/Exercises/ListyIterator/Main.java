package ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> data= Arrays.stream(scanner.nextLine().split("\\s+"))
                .skip(1).collect(Collectors.toCollection(ArrayList::new));
        //List<String> elements=new ArrayList<>();
        //elements= Arrays.asList(Arrays.stream(line.split("\\s+")).toString());
        ListyIterator listyIterator=new ListyIterator(data);

        String line= scanner.nextLine();
        while (!line.equals("END")){
            switch (line){
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        System.out.println(listyIterator.toString());
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
            }


            line= scanner.nextLine();
        }

    }
}
