import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String inputPath = "inputLineNumbers.txt";
        String outputPath = "5output.txt";
        BufferedReader br = null;
        PrintWriter writer = null;

        try {
            br = new BufferedReader(new FileReader(inputPath));
            writer = new PrintWriter(outputPath);
            int count = 1;
            String line = br.readLine();
            while (line != null) {
                String numberedLine = count + ". " + line;
                writer.write(numberedLine + System.lineSeparator());
                count++;
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}
