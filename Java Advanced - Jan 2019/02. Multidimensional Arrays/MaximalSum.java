import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] rowCols=scanner.nextLine().split(" ");
        int rows=Integer.parseInt(rowCols[0]);
        int cols=Integer.parseInt(rowCols[1]);
        int [][]matrix=new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }
        int maxSum=Integer.MIN_VALUE;
        int x=0;
        int y=0;
        for (int row = 1; row < rows-1; row++) {
            for (int col = 1; col < cols-1; col++) {
                int sum=matrix[row-1][col-1]+matrix[row-1][col]+matrix[row-1][col+1]
                        +matrix[row][col]+matrix[row][col-1]+matrix[row][col+1]
                        +matrix[row+1][col-1]+matrix[row+1][col]+matrix[row+1][col+1];
                if (sum>maxSum){
                    maxSum=sum;
                    x=row;
                    y=col;
                }
            }
        }
        System.out.println("Sum = "+maxSum);
        printMatrix(matrix,x,y);
    }

    private static void printMatrix(int[][] result, int x, int y) {
        for (int row = x-1; row <= x+1; row++) {
            for (int col = y-1; col <= y+1; col++) {
                System.out.print(result[row][col] + " ");
            }
            System.out.println();
        }
    }
}
