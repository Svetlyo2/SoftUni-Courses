package GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> intScale = new Scale<>(5, 7);
        System.out.println(intScale.getHeavier());
    }
}
