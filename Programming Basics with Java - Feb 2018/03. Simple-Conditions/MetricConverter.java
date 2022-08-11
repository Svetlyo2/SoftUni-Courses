import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double size = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine().toLowerCase();
        String output = scanner.nextLine().toLowerCase();
        double msize = 0;
        double outsize = 0;
        if (input.equals("cm")) {
            msize = size / 100;
        } else if (input.equals("mm")) {
            msize = size/1000;
        } else if (input.equals("m"))  {
            msize = size;
        } else if (input.equals("mi")) {
            msize = size / 0.000621371192;
        } else if (input.equals("in")) {
            msize = size / 39.3700787;
        } else if (input.equals("km")) { msize = size / 0.001;
        } else if (input.equals("ft")) { msize = size / 3.2808399;
        } else if (input.equals("yd")) { msize = size / 1.0936133;}

        if (output.equals("cm")) { outsize = msize * 100;
        } else if (output.equals("mm")) { outsize = msize * 1000;
        } else if (output.equals("m"))  { outsize = msize * 1;
        } else if (output.equals("mi")) { outsize = msize * 0.000621371192;
        } else if (output.equals("in")) { outsize = msize * 39.3700787;
        } else if (output.equals("km")) { outsize = msize * 0.001;
        } else if (output.equals("ft")) { outsize = msize * 3.2808399;
        } else if (output.equals("yd")) { outsize = msize * 1.0936133;}

        System.out.printf("%.8f %s", outsize, output);
    }
}
