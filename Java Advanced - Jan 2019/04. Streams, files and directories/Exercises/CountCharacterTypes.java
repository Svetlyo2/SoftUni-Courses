import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String inputPath = "input.txt";
        String outputPath = "4output.txt";
        BufferedReader br = null;
        PrintWriter writer = null;
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        List<Character> punctuationList = Arrays.asList('!', ',', '.', '?');
        int vowelsCount = 0;
        int punctuation = 0;
        int consonants = 0;

        try {
            br = new BufferedReader(new FileReader(inputPath));
            writer = new PrintWriter(outputPath);

            String line = br.readLine();
            while (line != null) {
                char[] lineChars = line.toCharArray();
                for (int i = 0; i < line.length(); i++) {
                    if (vowels.contains(lineChars[i])) {
                        vowelsCount++;
                    } else if (punctuationList.contains(lineChars[i])) {
                        punctuation++;
                    } else if (lineChars[i] != ' ') {
                        consonants++;
                    }
                }
                line = br.readLine();
            }
            writer.write("Vowels: " + vowelsCount + System.lineSeparator());
            writer.write("Consonants: " + consonants + System.lineSeparator());
            writer.write("Punctuation: " + punctuation + System.lineSeparator());

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
