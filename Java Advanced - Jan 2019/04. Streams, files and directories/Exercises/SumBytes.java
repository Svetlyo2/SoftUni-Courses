import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String inputPath = "input.txt";
        BufferedReader br = null;
        long sum = 0;

        try {
            br = new BufferedReader(new FileReader(inputPath));
            String line = br.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                line = br.readLine();
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
