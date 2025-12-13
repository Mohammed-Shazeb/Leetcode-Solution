import java.util.*;

class MyHashMap {

    private class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int n;        // number of nodes
    private int N;        // bucket size
    private LinkedList<Node>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        this.N = 4;
        this.buckets = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int key) {
        return Math.abs(key) % N;
    }

    private int searchInLL(int key, int bi) {
        LinkedList<Node> ll = buckets[bi];
        int di = 0;

        for (Node node : ll) {
            if (node.key == key) {
                return di;
            }
            di++;
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        LinkedList<Node>[] oldBuckets = buckets;
        N = 2 * N;
        buckets = new LinkedList[N];

        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList<>();
        }

        n = 0;
        for (LinkedList<Node> ll : oldBuckets) {
            for (Node node : ll) {
                put(node.key, node.value);
            }
        }
    }

    public void put(int key, int value) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if (di != -1) {
            buckets[bi].get(di).value = value;
        } else {
            buckets[bi].add(new Node(key, value));
            n++;
        }

        double lambda = (double) n / N;
        if (lambda > 2.0) {
            rehash();
        }
    }

    public int get(int key) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if (di != -1) {
            return buckets[bi].get(di).value;
        }
        return -1;
    }

    public void remove(int key) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if (di != -1) {
            buckets[bi].remove(di);
            n--;
        }
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
