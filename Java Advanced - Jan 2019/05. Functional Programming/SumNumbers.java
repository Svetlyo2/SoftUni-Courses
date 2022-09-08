import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input=scanner.nextLine().split(", ");

        Function <String,Integer> parser= number->Integer.parseInt(number);
        int sum= Arrays.stream(input)
                .map(parser)
                .reduce(0,(a,b)->a+b);

        System.out.println("Count = "+input.length);
        System.out.println("Sum = "+sum);
    }
}
