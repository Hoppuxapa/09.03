import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MyHashMap<K, V>{

    public MyHashMap(){
        hashTable = new Node[1000];
        threshold = hashTable.length * 0.60f;
    }
    private Node<K, V>[] hashTable;
    private int size = 0;
    private float threshold;


    public boolean put(final K key,final V value) {
        if (size + 1 >= threshold) {
            threshold *= 2;
            doubleMyArray();
        }
        Node<K, V> newNode = new Node<>(key, value);
        int i = hash(key);
        if (hashTable[i] == null) {
            return add(i, newNode);
        }

        List<Node<K, V>> nodeList = hashTable[i].getNodes();

        for (Node<K, V> node : nodeList) {
            if (keyExistButValueNew(node, newNode, value) || collisionProcessing(node, newNode, nodeList)) {
                return true;
            }
        }
        return false;

    }

    private boolean collisionProcessing
            (final Node<K, V> nodeFromList,
            final Node<K, V> newNode,
            final List<Node<K, V>> nodes)
    {
        if (newNode.hashCode() == nodeFromList.hashCode() &&
                !Objects.equals(newNode.key, nodeFromList.key) &&
                !Objects.equals(newNode.value, nodeFromList.value)) {
            nodes.add(newNode);
            size++;
            return true;
        }
        return false;
    }

    private boolean keyExistButValueNew
            (final Node<K, V> nodeFromList,
             final Node<K, V> newNode,
             final V value)
    {
        if (newNode.getKey().equals(nodeFromList.getKey()) && !newNode.getValue().equals(nodeFromList.getValue())) {
            nodeFromList.setValue(value);
            return true;
        }
        return false;
    }

    private boolean add(int i, Node<K, V> newNode) {
        hashTable[i] = new Node<>(null, null);
        hashTable[i].getNodes().add(newNode);
        size++;
        return true;
    }

    private void doubleMyArray() {
        Node<K, V>[] oldHashTable = hashTable;
        hashTable = new Node[oldHashTable.length * 2];
        size = 0;
        for (Node<K, V> node : oldHashTable) {
            if (node != null) {
                for (Node<K, V> n : node.getNodes()) {
                    put(n.key, n.value);
                }
            }
        }
    }


    private int hash(Node<K, V> node) {
        return node.hashCode() % hashTable.length;
    }

   public boolean remove(final K key){
        int i = hash(key);
        if (hashTable[i] == null) {
            return false;
        }

        if (hashTable[i].getNodes().size() == 1) {
            hashTable[i].getNodes().remove(0);
        }

        List<Node<K, V>> nodeList = hashTable[i].getNodes();
        for (Node<K, V> node : nodeList) {
            if (key.equals(node.getKey())) {
                nodeList.remove(node);
                return true;
            }
        }
        return true;
    }

    public boolean clear() {
        hashTable = new Node[1000];
        size = 0;
        return true;}

    public int size(){
        return size;
    }

    public V get(K key){
        int i = hash( key);
        if (i < hashTable.length &&
                hashTable[i] != null) {
            List<Node<K, V>> list = hashTable[i].getNodes();
            for (Node<K, V> node : list) {
                if (key.equals(node.getKey())) {
                    return node.getValue();
                }
            }
        }
        return null;
    }

    private int hash(final K key) {
        int hash;
        hash = 527 + key.hashCode();
        return hash;
    }

    private class Node<K, V> {
        private List<Node<K, V>> nodes;


        private int hash;

        private K key;
        private V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            nodes = new LinkedList<Node<K, V>>();
        }

        public void setNodes(List<Node<K, V>> nodes) {
            this.nodes = nodes;
        }

        private List<Node<K, V>> getNodes() {
            return nodes;
        }

        public int hash() {
            return hashCode() % hashTable.length;
        }

        private K getKey() {
            return key;
        }

        private V getValue() {
            return value;
        }

        private void setValue(V value) {
            this.value = value;
        }

        // Переопределяем хэшкод, чтобы минимизировать коллизии для разных значений c одиннаковыми ключами

        public int hashCode() {
            int hash;
            hash = 527 + value.hashCode();
            return hash;
        }

        // Проверям является ли пришедший объект того же класса, что и объекты изначально. Если одиннаковые,
        // то сравниваем пришедший объект с ключем и значением, и переопределяем его хэшкод.

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Node) {
                Node<K, V> node = (Node) obj;
                return (Objects.equals(key, node.getKey()) &&
                        Objects.equals(value, node.getValue()) ||
                        Objects.equals(hash, node.hashCode()));
            }
            return false;
        }
    }
}