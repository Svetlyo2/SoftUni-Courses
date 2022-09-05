import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String base="D:\\dox\\Softuni\\JavaAdv\\FilesStreams\\Lab-Resources";
        String inputPath=base+"\\input.txt";
        String outputPath=base+"\\05.WriteEveryThirdLineOutput.txt";
        BufferedReader br=null;
        PrintWriter print=null;
            int count=1;
        try {
            br=new BufferedReader(new FileReader(inputPath));
            print=new PrintWriter(new FileWriter(outputPath));

                String line=br.readLine();
            while (line!=null){
                if (count%3==0){
                    print.println(line);
                    //System.out.println(line);
                }
                count++;
                line=br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (br !=null){
                br.close();
            }
            if (print!=null){
                print.close();
            }
        }
    }
}
