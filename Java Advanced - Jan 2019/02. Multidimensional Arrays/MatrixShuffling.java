import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] rowCols=scanner.nextLine().split(" ");
        int rows=Integer.parseInt(rowCols[0]);
        int cols=Integer.parseInt(rowCols[1]);
        String [][]matrix=new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] arr = scanner.nextLine().split(" ");
            matrix[row] = arr;
        }
        String [] line= scanner.nextLine().split("\\s+");
        while (line.length>1){
            boolean isValid=true;
            int x1,x2,y1,y2;
            if (line.length == 5) {
                x1 = Integer.parseInt(line[1]);
                y1 = Integer.parseInt(line[2]);
                x2 = Integer.parseInt(line[3]);
                y2 = Integer.parseInt(line[4]);
                if (x1 >= 0 && x1 < cols && y1 >= 0 || y1 < rows && x2 >= 0 && x2 < cols && y2 >= 0 && y2 < rows) {
                    String temp = matrix[x1][y1];
                    matrix[x1][y1] = matrix[x2][y2];
                    matrix[x2][y2] = temp;
                } else {
                    System.out.println("Invalid input!");
                    isValid = false;
                }
                if (isValid) {
                    printMatrix(matrix);
                }
            } else {
                System.out.println("Invalid input!");
            }
            line = scanner.nextLine().split("\\s+");
        }
    }

    private static void printMatrix(String[][] result) {
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                if (col < result[row].length - 1) {
                    System.out.print(result[row][col] + " ");
                } else {
                    System.out.print(result[row][col]);
                }
            }
            System.out.println();
        }
    }
}
