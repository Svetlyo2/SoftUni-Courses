import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        String base="D:\\dox\\Softuni\\JavaAdv\\FilesStreams\\Lab-Resources";
        String input=base+"\\6input.txt";
        String output=base+"\\06.SortLinesOutput.txt";
        Path inputPath=Paths.get(input);
        Path outputPath=Paths.get(output);

        try {
            List <String> lines=Files.readAllLines(inputPath);
            Collections.sort(lines);
            Files.write(outputPath,lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
