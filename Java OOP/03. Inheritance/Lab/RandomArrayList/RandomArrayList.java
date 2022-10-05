package RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    private Random random;

    RandomArrayList() {
        super();
        this.random = new Random();
    }

    public T getRandomElement() {
        if (this.size() == 0) {
            throw new IllegalArgumentException("The list is empty");
        }
        int index = this.random.nextInt(super.size());
        T element = super.get(index);
        super.remove(index);
        return element;
    }
}
//W/O GENERIC
//public class RandomArrayList extends ArrayList {
//    private Random random;
//
//    RandomArrayList(){
//        super();
//        this.random = new Random();
//    }
//
//    public Object getRandomElement(){
//        int index = this.random.nextInt(super.size());
//        Object element = super.get(index);
//        super.remove(index);
//        return element;
//    }
//}
