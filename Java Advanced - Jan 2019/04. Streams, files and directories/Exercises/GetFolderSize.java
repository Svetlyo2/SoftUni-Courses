import java.io.File;
import java.util.Arrays;

public class GetFolderSize {
    public static void main(String[] args) {
        String input = "Exercises Resources";
        File files = new File(input);
        long sum = Arrays.stream(files.listFiles())
                .filter(e -> !e.isDirectory())
                .mapToLong(e -> e.length())
                .sum();
        System.out.println("Folder size: " + sum);
    }
}
