package cn.com.xvym.learning.leetcode.no146;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Xv
 * @Date: 2021/5/16 16:18
 * @Description:
 */
public class DLinkedListTest {

    class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;

        public ListNode() {
        }

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Integer capacity;

    private Integer size;

    private Map<Integer, ListNode> cache;

    private ListNode head;

    private ListNode tail;

    public DLinkedListTest(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        cache = new HashMap<>(capacity);
        // 头尾节点均为哑节点
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode res = cache.get(key);
        boolean contained = res != null;
        if (contained) {
            moveToHead(res);
        }
        return contained ? res.val : -1;
    }

    public void put(int key, int value) {
        ListNode res = cache.get(key);
        boolean contained = res != null;
        if (contained) {
            res.val = value;
            moveToHead(res);
        } else {
            ListNode listNode = new ListNode(key, value);
            addToHead(listNode);
            size++;
            if (size > capacity) {
                ListNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
            cache.put(key, listNode);
        }
    }

    private void moveToHead(ListNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(ListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private ListNode removeTail() {
        ListNode res = tail.prev;
        removeNode(res);
        return res;
    }
}


