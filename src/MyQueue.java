import java.util.Arrays;

public class MyQueue<T> {

    T[] queue;
    private int size = 0;

    public MyQueue(T[] queue) {
        this.queue = queue;
        this.size = queue.length;
    }

    public int size() {
        return size;
    }

    public void add(T value) {
        if (size < queue.length) {
            queue[size] = value;
            size++;
        }
    }

    public void remove(int index) {
        T[] tmp = queue.clone();
        queue = Arrays.copyOf(queue, queue.length - 1);
        System.arraycopy(tmp, 0, queue, 0, index);
        int quantityAfter = tmp.length - index - 1;
        System.arraycopy(tmp, index + 1, queue, index, quantityAfter);
    }

    public void clear() {
        size = 0;
    }

    public T peek() {
        return queue[0];
    }

    public T poll() {
        T[] tmp = queue.clone();
        T first = queue[0];
        size--;
        System.arraycopy(tmp, 1, queue, 0, size);

        return first;
    }
}
