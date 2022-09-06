import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class allCapitals {
    public static void main(String[] args) throws IOException {
        String inputPath = "input.txt";
        String outputPath = "3output.txt";
        BufferedReader br = null;
        PrintWriter writer = null;

        try {
            br = new BufferedReader(new FileReader(inputPath));
            writer = new PrintWriter(outputPath);

            String line = br.readLine();
            while (line != null) {
                String capitalized = line.toUpperCase();
                writer.println(capitalized);
                line = br.readLine();
//                System.out.println(capitalized);
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
