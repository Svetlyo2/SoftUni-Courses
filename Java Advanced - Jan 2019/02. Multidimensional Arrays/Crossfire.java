import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rowCols = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(rowCols[0]);
        int cols = Integer.parseInt(rowCols[1]);
        if (cols > 100 || cols < 2 || rows > 100 || rows < 2) {
            return;
        }
        int count = 1;
        List<List<Integer>> matrix = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(count);
                count++;
            }
        }
        String line = scanner.nextLine();
        while (!line.equals("Nuke it from orbit")) {
            int[] command = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int bombRow = command[0];
            int bombCol = command[1];
            int radius = command[2];
            for (int i = bombRow - radius; i <= bombRow + radius; i++) {
                if (isInRange(i, bombCol, matrix) && i != bombRow) {
                    matrix.get(i).remove(bombCol);
                }
            }

            for (int i = bombCol + radius; i >= bombCol - radius; i--) {
                if (isInRange(bombRow, i, matrix)) {
                    matrix.get(bombRow).remove(i);
                }
            }
            matrix.removeIf(List::isEmpty);
            line = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        boolean inRange = row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
        return inRange;
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
