import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        String base="D:\\dox\\Softuni\\JavaAdv\\FilesStreams\\Lab-Resources";
        String path=base+"\\input.txt";
        String outputPath=base+"\\02.WriteToFileOutput.txt";
        List<Character> punctuation=Arrays.asList(',','.','!','?');
        //another option
        //Collections.addAll(punctuation, '.', ',', '!', '?');


        FileInputStream inputStream =null;
        FileOutputStream outputStream=null;
        try {
            inputStream = new FileInputStream(path);
            outputStream=new FileOutputStream(outputPath);
            int byteData=inputStream.read();
            while (byteData>=0){
                if (!punctuation.contains((char)byteData)){
                    outputStream.write(byteData);
                }
                byteData=inputStream.read();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

    }
}
