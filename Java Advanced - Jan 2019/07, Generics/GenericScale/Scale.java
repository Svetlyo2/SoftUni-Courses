package GenericScale;

public class Scale <T extends  Comparable>{
    T left;
    T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier(){
        if (left.compareTo(right)>0){
            return left;
        }
        if (left.compareTo(right)==0){
            return null;
        }
        return right;
    }
}
