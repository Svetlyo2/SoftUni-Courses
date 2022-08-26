import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] sizeType=scanner.nextLine().split(", ");
        int size=Integer.parseInt(sizeType[0]);
        int [][] matrix=new int[size][size];
        String type=sizeType[1];
        if (type.equals("A")) {
            matrix = fillMatrixA(size, matrix);
        } else {
            matrix = fillMatrixB(size, matrix);
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixB(int size, int[][] matrix) {
        int col=0;
        int current=1;
        while (col<size) {
            if (col%2==0){
                for (int row = 0; row < size; row++) {
                    matrix[row][col]=current++;
                }
            } else {
                for (int row = size-1; row >=0; row--) {
                    matrix[row][col]=current++;
                }
            }
            col++;
        }
        return matrix;
    }

    private static int [][] fillMatrixA(int size, int[][] matrix) {
        int col=0;
        int current=1;
        while (col<size) {
            for (int row = 0; row < size; row++) {
                matrix[row][col]=current++;
            }
            col++;
        }
        return matrix;
    }
}
