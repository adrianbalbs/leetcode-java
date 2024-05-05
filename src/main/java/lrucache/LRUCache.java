package lrucache;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;
    ListNode() {}
    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {
    int capacity;
    ListNode left = new ListNode();
    ListNode right = new ListNode();
    Map<Integer, ListNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        left.next = right;
        right.prev = left;
    }
    private void insert(ListNode node) {
        ListNode prev = right.prev;
        ListNode next = right;

        prev.next = node;
        next.prev = node;
        node.next = next;
        node.prev = prev;
    }

    private void remove(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        map.put(key, new ListNode(key, value));
        insert(map.get(key));

        if (map.size() > capacity) {
            ListNode lru = left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
