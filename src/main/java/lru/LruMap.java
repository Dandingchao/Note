package lru;

import java.util.HashMap;
import java.util.Map;

public class LruMap {
    private static int capacity=10;
    private Map<String, Node> map=new HashMap<>(capacity);
    private Node head;
    private Node tail;

    public Map<String, Node> getMap() {
        return map;
    }

    public void setMap(Map<String, Node> map) {
        this.map = map;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public String get(String key){
        Node node=map.get(key);
        if (node !=null){
            Node prev = node.getPrev();
            Node next = node.getNext();
            if (prev!=null){
                prev.setNext(node.getNext());
            }
            if (next!=null){
                next.setPrev(node.getPrev());
            }
            node.setPrev(null);
            node.setNext(head);
            head=node;
            return node.getValue();
        }
        return null;
    }
    public void put(Node node){
        Node origin= map.get(node.getKey());
        if (node !=null){
            String key=node.getKey();
            Node prev = node.getPrev();
            Node next = node.getNext();
            if (prev!=null){
                prev.setNext(node.getNext());
            }
            if (next!=null){
                next.setPrev(node.getPrev());
            }
        }
        node.setPrev(null);
        node.setNext(head);
        head=node;
        if (map.size()>capacity){
            Node last=tail;

        }
    }

}
