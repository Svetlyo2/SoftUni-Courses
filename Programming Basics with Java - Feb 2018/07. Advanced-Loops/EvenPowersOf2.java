import java.util.Scanner;

public class EvenPowersOf2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        Integer num =1;
        System.out.println(num);

        for (int i = 2; i <= n ; i+=2) {
            num=num*4;
            System.out.println(num);
        }
    }
}
