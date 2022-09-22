package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private static final int DEFAULT_INDEX = -1;
    private List<String> elements;
    private int index;

    public ListyIterator(ArrayList<String> elements) {
        this.elements = elements;
        this.setIndex();
    }

    public String toString() {
        if (this.elements.size() == 0) {
            throw new IndexOutOfBoundsException("Invalid Operation!");
        }
        return this.elements.get(this.index);
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        if (elements.size() == 0) {
            this.elements = new ArrayList<>();
        } else {
            this.elements.addAll(elements);
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex() {
        if (this.elements.size() == 0) {
            this.index = DEFAULT_INDEX;
        } else {
            this.index = 0;
        }
    }


    public boolean hasNext() {
        return this.index < this.elements.size() - 1;
    }


    public boolean move() {
        if (index < elements.size() - 1) {
            this.index++;
            return true;
        } else return false;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            private int indexx = 0;

            @Override
            public boolean hasNext() {
                return this.indexx < elements.size();
            }

            @Override
            public String next() {
                return elements.get(this.indexx++);
            }
        };
    }
}
