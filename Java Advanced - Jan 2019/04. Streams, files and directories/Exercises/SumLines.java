import java.io.*;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String inputPath = "input.txt";
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(inputPath));
            String line = br.readLine();
            while (line != null) {
                int sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                System.out.println(sum);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
