import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Integer maxNum = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if (maxNum<num) {
                maxNum = num;
            }
        }
        System.out.println(maxNum);
    }
}
