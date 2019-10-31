import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements Iterator<T> {

    private int index = 0;
    private T[] value;

    @Override
    public boolean hasNext() {
        return index < value.length;
    }

    @Override
    public T next() {
        return value[index++];
    }

    public MyArrayList(T[] t) {
        value = t;
    }

    public void add(T t) {
        value = Arrays.copyOf(value, value.length + 1);
        value[value.length - 1] = t;
    }

    public void remove(int index) {
        T[] tmp = value.clone();
        value = Arrays.copyOf(value, value.length - 1);
        System.arraycopy(tmp, 0, value, 0, index);
        int quantityAfter  = tmp.length-index -1;
        System.arraycopy(tmp, index + 1, value, index, quantityAfter);
    }

    public void clear() {
         value = (T[]) new Object[]{};
    }

    public int size() {
        return value.length;
    }

    public int get(int index) {
        return index;
    }


}
