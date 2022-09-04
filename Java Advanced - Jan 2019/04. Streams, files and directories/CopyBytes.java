import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String base="D:\\dox\\Softuni\\JavaAdv\\FilesStreams\\Lab-Resources";
        String path=base+"\\input.txt";
        String outputPath=base+"\\03.CopyBytesOutput.txt";
        FileInputStream inputStream =null;
        FileOutputStream outputStream=null;
        try {
            inputStream = new FileInputStream(path);
            outputStream=new FileOutputStream(outputPath);
            int byteData=inputStream.read();
            while (byteData>=0){
                if (byteData==10 || byteData==32){
                    outputStream.write(byteData);
                } else {
                    String digits=String.valueOf(byteData);
                    for (int i = 0; i < digits.length(); i++) {
                        outputStream.write(digits.charAt(i));
                    }
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
            if (outputStream !=null){
                outputStream.close();
            }
        }
    }
}
