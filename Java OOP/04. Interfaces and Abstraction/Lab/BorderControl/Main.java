package BorderControl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Identifiable> entering = new ArrayList<>();
        List<String> idsEntering = new ArrayList<>();
        while (!"End".equals(line)) {
            String[] data = line.split("\\s+");
            if (data.length == 2) {
                idsEntering.add(data[1]);
                Identifiable robot = new Robot(data[1], data[0]);
                entering.add(robot);
            } else {
                idsEntering.add(data[2]);
                Identifiable citizen = new Citizen(data[0], Integer.parseInt(data[1]), data[2]);
                entering.add(citizen);
            }
            line = scanner.nextLine();
        }
        String targetIds = scanner.nextLine();
        entering.stream().filter(e -> e.getId().endsWith(targetIds)).forEach(a -> System.out.println(a.getId()));

//        for (String id : idsEntering) {
//            if (id.endsWith(targetIds)){
//                System.out.println(id);
//            }
//        }
    }
}
