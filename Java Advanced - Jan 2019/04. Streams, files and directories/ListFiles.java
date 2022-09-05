import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ListFiles {
    public static void main(String[] args) {
        String base = "D:\\dox\\Softuni\\JavaAdv\\FilesStreams\\Lab-Resources";
        String input = base + "\\Files-and-Streams";
        String output = base + "\\7output.txt";

        PrintWriter writer = null;
        File folderToRead = new File(input);
        File[] files = folderToRead.listFiles();

        try {
            writer = new PrintWriter(new FileWriter(output));
            for (File file : files) {
                if (!file.isDirectory()) {
                    writer.println(file.getName() + ": [" + file.length() + "]");
                }
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
