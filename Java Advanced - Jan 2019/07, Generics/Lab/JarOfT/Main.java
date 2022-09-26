package JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<String> jarOfPickle = new Jar<>();
        jarOfPickle.add("cucumber");
        jarOfPickle.add("tomato");
        System.out.println(jarOfPickle.remove());
    }
}
