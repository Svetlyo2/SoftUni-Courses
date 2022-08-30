import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        TreeSet<String> guests=new TreeSet<>();

        while (!line.equals("PARTY")){
            guests.add(line);
            line=scanner.nextLine();
        }
        while (!line.equals("END")){
            guests.remove(line);
            line=scanner.nextLine();
        }
        System.out.println(guests.size());
        for (String guest:
             guests) {
            System.out.println(guest);
        }
    }
}
