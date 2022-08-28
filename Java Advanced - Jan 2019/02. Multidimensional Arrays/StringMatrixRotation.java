import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int maxLength = 0;
        char[][] matrix = new char[1000][];
        String line = scanner.nextLine();
        String[] command = line.split("\\D+");
        int rotation = Integer.parseInt(command[1]) % 360;
        line = scanner.nextLine();
        while (!line.equals("END")) {
            matrix[count] = line.toCharArray();
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
            count++;
            line = scanner.nextLine();
        }
        char[][] inputMatr = new char[count][maxLength];
        for (int row = 0; row < count; row++) {
            for (int col = 0; col < maxLength; col++) {
                if (col >= matrix[row].length) {
                    inputMatr[row][col] = ' ';
                } else {
                    inputMatr[row][col] = matrix[row][col];
                }
            }
        }
        if (rotation == 90) {
            for (int row = 0; row < maxLength; row++) {
                for (int col = count - 1; col >= 0; col--) {
                    System.out.print(inputMatr[col][row]);
                }
                System.out.println();
            }
        } else if (rotation == 180) {
            for (int row = count - 1; row >= 0; row--) {
                for (int col = maxLength - 1; col >= 0; col--) {
                    System.out.print(inputMatr[row][col]);
                }
                System.out.println();
            }
        } else if (rotation == 270) {
            for (int row = maxLength - 1; row >= 0; row--) {
                for (int col = 0; col < count; col++) {
                    System.out.print(inputMatr[col][row]);
                }
                System.out.println();
            }

        } else {
            printMatrix(inputMatr);
        }
    }

    private static void printMatrix(char[][] result) {
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                System.out.print(result[row][col]);
            }
            System.out.println();
        }
    }

}
