import java.util.Scanner;

public class RecursiveFibonacci {
    static long [] memory;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number =Integer.parseInt(scanner.nextLine());
        memory=new long[number+1];
        System.out.println(getFibo(number));
    }

    private static long getFibo(int n) {
        if (n<2){
            return 1;
        }
        if (memory [n]!=0){
            return memory[n];
        }
        return memory[n]=getFibo(n-1)+getFibo(n-2);
    }
}
