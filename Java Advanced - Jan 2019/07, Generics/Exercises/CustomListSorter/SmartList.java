package CustomListSorter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SmartList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> data;

    public SmartList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T remove(int index) {
        return this.data.remove(index);
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T temp = this.data.get(firstIndex);
        this.data.set(firstIndex, this.data.get(secondIndex));
        this.data.set(secondIndex, temp);
    }

    public int greaterCount(T element) {
        return this.data.stream().filter(e -> e.compareTo(element) > 0)
                .toArray().length;
    }

    public T getMax() {
        return this.data.stream().max(T::compareTo).get();
    }

    public T getMin() {
        return this.data.stream().min(T::compareTo).get();
    }

// can not be used together with Iterator!!
//    public void forEach(Consumer<T> consumer){
//        for (int i = 0; i < this.data.size(); i++) {
//            consumer.accept(this.data.get(i));
//        }
//    }
    public int size() {
        return this.data.size();
    }

    public T get(int index) {
        return this.data.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return this.data.iterator();
    }
}
