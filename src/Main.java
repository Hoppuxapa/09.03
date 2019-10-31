import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

      /*  Integer[] mas = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        MyArrayList<Integer> myArrayList = new MyArrayList<>(mas);

        myArrayList.clear();

        for (MyArrayList<Integer> it = myArrayList; it.hasNext(); ) {
            Integer i = it.next();
            System.out.println(i);
        }
        myArrayList.add(45);

        myArrayList.remove(0);


        System.out.println(myArrayList.get(4));

        System.out.println(myArrayList.size());

        myArrayList.clear();

        myArrayList.add(11);

        for (MyArrayList<Integer> its = myArrayList; its.hasNext(); ) {
            Integer i = its.next();
            System.out.println(i);
        }*/



/*
       MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(45);
        myLinkedList.add(48);
        myLinkedList.add(49);
        myLinkedList.add(50);
        myLinkedList.add(64);
        myLinkedList.remove(1);
        for (int i = 0; i <myLinkedList.size() ; i++) {
            System.out.println(myLinkedList.get(i));
        }

*/

        Integer[] mas = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

       /* MyQueue myQueue = new MyQueue(mas);
        myQueue.remove(5);
        for (int i = 0; i <myQueue.size() ; i++) {
            System.out.println(i);
        }*/

      /*  MyStack myStack = new MyStack(mas);
        System.out.println(myStack.peek());
        myStack.remove(1);
        for (int i = 0; i < myStack.size() - 1; i++) {
            System.out.println(i);

        }*/


        MyHashMap<Integer, String> myHashMap = new MyHashMap();
        myHashMap.put(0, "Hello");
        myHashMap.put(1, "World!");
        myHashMap.put(2, "Hi");
        System.out.println(myHashMap.clear());
        System.out.println(myHashMap.get(2));
        myHashMap.put(1, "llo");
        myHashMap.put(4, "ello");
        System.out.println(myHashMap.size());
        System.out.println(myHashMap.remove(1));
        System.out.println(myHashMap.get(1));
    }
}

