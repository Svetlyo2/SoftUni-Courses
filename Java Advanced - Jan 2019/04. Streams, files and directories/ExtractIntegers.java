import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String base = "D:\\dox\\Softuni\\JavaAdv\\FilesStreams\\Lab-Resources";
        String inputPath = base + "\\input.txt";
        String outputPath = base + "\\04ExtractIntegersOutput.txt";

        try {
            Scanner scanner = new Scanner(new FileInputStream(inputPath));
            PrintStream print = new PrintStream(outputPath);
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    print.println(scanner.nextInt());
                }
                scanner.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
