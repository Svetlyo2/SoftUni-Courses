import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Character, Integer> characters  =new TreeMap<>();
        String input=scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char c=input.charAt(i);
            if (!characters.containsKey(c)){
                characters.put(c,0);
            }
            characters.put(c,characters.get(c)+1);
        }
        for (Character key:characters.keySet()){
            System.out.println(key+": "+characters.get(key)+" time/s");
        }
    }
}
