import java.util.Arrays;

public class MyStack<T> {

    private T[] stack;

    private int size = 0;

    public MyStack(T[] stack) {
        this.stack = stack;
        this.size = stack.length;
    }


    public void push(T value) {
    }

    public void remove(int index) {
        T[] tmp = stack.clone();
        stack = Arrays.copyOf(stack, stack.length - 1);
        System.arraycopy(tmp, 0, stack, 0, index);
        int quantityAfter = tmp.length - index - 1;
        System.arraycopy(tmp, index + 1, stack, index, quantityAfter);
    }

    public void clear() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return stack[size - 1];
    }

    public T pop() {
        if (size != 0) {
            size--;
        }
        return (stack[size]);
    }
}
