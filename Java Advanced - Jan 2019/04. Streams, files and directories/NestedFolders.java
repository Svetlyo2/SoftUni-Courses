import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class NestedFolders {
    public static void main(String[] args) {
        String base = "D:\\dox\\Softuni\\JavaAdv\\FilesStreams\\Lab-Resources";
        String input = base + "\\Files-and-Streams";
        String output = base + "\\8output.txt";

        PrintWriter writer = null;
        File folderToRead = new File(input);

        int foldersCount = 0;

        try {
            writer = new PrintWriter(new FileWriter(output));
            ArrayDeque<File> filesToCheck =
                    new ArrayDeque<>(Arrays.asList(folderToRead));
            while (!filesToCheck.isEmpty()) {
                File currentFile = filesToCheck.poll();
                if (currentFile.isDirectory()) {
                    filesToCheck.addAll(Arrays.asList(currentFile.listFiles()));
                    writer.println(currentFile.getName());
                    foldersCount++;
                }
            }
            writer.println(foldersCount + " folders");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
