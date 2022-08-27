import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size=Integer.parseInt(scanner.nextLine());
        int [][]matrix=new int[size][size];
        for (int row = 0; row < size; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }
        int firstD=0;
        int secondD=0;
        for (int row = 0; row < size; row++) {
            firstD+=matrix[row][row];
            secondD+=matrix[size-row-1][row];

        }
//        System.out.println(firstD);
//        System.out.println(secondD);
        System.out.println(Math.abs(firstD-secondD));

    }
}
