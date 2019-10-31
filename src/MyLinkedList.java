

public class MyLinkedList<T> {
    public static MyLinkedList myLinkedList;

    private static int size = 0;
    private Node<T> first;
    private Node<T> last;

    MyLinkedList() {
        first = new Node<T>(null, null, last);
        last = new Node<T>(null, first, null);


    }


    public void add(T t) {
        Node<T> next = first;
        next.setElement(t);
        first = new Node<>(null, null, next);
        next.setPrev(first);
        size++;
    }



    public T get(int index) {
        Node<T> target = first.getNext();
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target.getElement();
    }

    public void remove(int index) {

        Node myLinkedList = first;

        if (first != null) {
            for (int i = 0; i < index; i++) {

                myLinkedList = myLinkedList.getNext();
            }
            myLinkedList.setNext(myLinkedList.getNext().getNext());

            size--;
        }

    }


    public int clear() {
        return size = 0;
    }

    public int size() {
        return size;
    }


    private Node<T> getNextElement(Node<T> current) {
        return current.getNext();
    }

    private static class Node<T> {


        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        private T element;
        private Node<T> prev;
        private Node<T> next;


        private Node(T element, Node<T> prev, Node<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }


    }
}
