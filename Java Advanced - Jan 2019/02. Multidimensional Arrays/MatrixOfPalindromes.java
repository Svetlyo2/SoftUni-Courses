import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] rowCols=scanner.nextLine().split(" ");
        int rows=Integer.parseInt(rowCols[0]);
        int cols=Integer.parseInt(rowCols[1]);
        String pal="";
        int letter='a';
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String element=""+(char)('a'+row)+(char)('a'+row+col)+(char)('a'+row);
            System.out.print(element+" ");
            }
            System.out.println();
        }
    }
}
