package adobe;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    LinkedList<Node> cache;
    int capacity;
    HashMap<Integer, Node> pages;
    Node head;

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.cache = new LinkedList<Node>();
        this.capacity = capacity;
        this.pages = new HashMap<>();
    }

    public int get(int key) {
        Node node =  pages.get(key);
        if(node == null) {
            return -1;
        }
        cache.remove(node);
        cache.add(node);
        //Node next = node.next;
        return node.value;
    }

    public void put(int key, int value) {
        if(pages.containsKey(key)) {
            Node node = pages.get(key);
            node.value = value;
            cache.remove(node);
            cache.add(node);
            return;
        }
        if(pages.size() == capacity) {
            //remove LRU node;
            Node node =  cache.remove();
            pages.remove(node.key);

            node = new Node(key, value);
            //add at the end of cache
            cache.add(node);
            // add to pages
            pages.put(key, node);
            return;
        }
        Node node = new Node(key, value);
        //add at the end of cache
        cache.add(node);
        // add to pages
        pages.put(key, node);

    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.get(2);
        obj.put(2,1);
        //obj.get(1);
        obj.put(1,1);
        //obj.get(2);
        obj.put(2,3);
        obj.put(4,1);
        obj.get(1);
        obj.get(2);
        //obj.get(4);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */