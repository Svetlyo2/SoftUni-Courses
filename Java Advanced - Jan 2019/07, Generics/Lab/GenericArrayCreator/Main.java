package GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        Integer[] integers = ArrayCreator.create(Integer.class, 10, 0);
        String[] strings = ArrayCreator.create(10, "none");
        int count = 0;
        for (Integer integer : integers) {
            System.out.println(count++ + " " + integer);

        }
        for (String string : strings) {
            System.out.println(count++ + " " + string);
        }
    }
}
