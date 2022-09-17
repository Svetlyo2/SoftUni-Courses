package GenericSwapMethodString;

public class BoxString <T> {
    private T element;

    public BoxString (T element) {
        this.element = element;
    }

    @Override
    public String toString(){
        return this.element.getClass().getName()+": "+ this.element;
    }
}
