import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String inPath = "words.txt";
        String textPath = "text.txt";
        String outputPath = "6result.txt";
        BufferedReader br = null;
        BufferedReader brText = null;
        PrintWriter writer = null;


        try {
            br = new BufferedReader(new FileReader(inPath));
            writer = new PrintWriter(outputPath);
            String line = br.readLine();
            List<String> words = Arrays.asList(line.split("\\s+"));
            brText = new BufferedReader(new FileReader(textPath));
            line = brText.readLine();
            HashMap<String, Integer> matches = new HashMap<>();
            while (line != null) {
                String[] textWords = line.split("\\s+");
                for (String word : textWords) {
                    if (words.contains(word)) {
                        matches.putIfAbsent(word, 0);
                        matches.put(word, matches.get(word) + 1);
                        //System.out.println(word+", "+matches.get(word));
                    }
                }
                line = brText.readLine();
            }
            //reverse sorting of Map by value
            LinkedHashMap<String, Integer> sortedByCount = matches.entrySet()
                    .stream()
                    .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            for (String word : sortedByCount.keySet()) {
                writer.write(word + " - " + sortedByCount.get(word) + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
            if (brText != null) {
                brText.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}
