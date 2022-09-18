package GenericCountMethodDoubles;

public class Box <T extends Comparable <T>> {
    private T element;

    public Box(T element) {
        this.element = element;
    }

    public int compareTo(Box<T> otherBox){
        return this.element.compareTo(otherBox.element);
    }
    }
