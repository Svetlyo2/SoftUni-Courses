import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        class Cube implements Serializable {
            String color;
            double width;
            double height;
            double depth;
        }
        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 15.3;
        cube.height = 12.4;
        cube.depth = 3.0;
        String path = "D:\\dox\\Softuni\\JavaAdv\\FilesStreams\\Lab-Resources\\9save.txt";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
