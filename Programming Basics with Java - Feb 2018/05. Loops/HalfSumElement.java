import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int dif2 = 0;
        Integer maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            sum += number;
            if (number > maxNum) {
                maxNum = number;
            }
        }
        Integer dif = sum - maxNum;

        boolean isEqual = (maxNum.equals(dif));
        if (isEqual) {
            System.out.printf("Yes\nSum = %d", maxNum);
        } else {
            dif2 = Math.abs(maxNum - (sum - maxNum));
            System.out.printf("No\nDiff = %d", dif2);
        }
    }
}
