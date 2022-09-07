import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public interface MergeTwoFiles {
    public static void main(String[] args) {

        Path inPath = Paths.get("inputOne.txt");
        Path inPath2 = Paths.get("inputTwo.txt");
        String outPath = "7output.txt";
        PrintWriter writer = null;

        try {
            List<String> first = Files.readAllLines(inPath);
            List<String> second = Files.readAllLines(inPath2);
            writer = new PrintWriter(outPath);

            for (String line : first) {
                writer.write(line + System.lineSeparator());
            }
            for (String line : second) {
                writer.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
