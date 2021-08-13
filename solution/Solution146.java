import java.util.HashMap;

public class Solution146 {
    static class LRUCache {
        static class DLinkedListNode {
            protected int key, val;
            protected DLinkedListNode prev, next;

            DLinkedListNode(int k, int v) {
                key = k;
                val = v;
                prev = null;
                next = null;
            }
        }

        static class DLinkedList {
            protected DLinkedListNode dummyHead, dummyTail;

            DLinkedList() {
                dummyHead = new DLinkedListNode(-1, -1);
                dummyTail = new DLinkedListNode(-1, -1);
                dummyHead.next = dummyTail;
                dummyTail.prev = dummyHead;
            }

            void moveToHead(DLinkedListNode curr) {
                if (curr == dummyHead.next) return;
                DLinkedListNode head = dummyHead.next, currNext = curr.next, currPrev = curr.prev;
                dummyHead.next = curr;
                curr.prev = dummyHead;
                curr.next = head;
                head.prev = curr;
                currPrev.next = currNext;
                currNext.prev = currPrev;
            }

            void insertAtHead(DLinkedListNode curr) {
                DLinkedListNode head = dummyHead.next;
                dummyHead.next = curr;
                curr.prev = dummyHead;
                curr.next = head;
                head.prev = curr;
            }

            DLinkedListNode removeTail() {
                DLinkedListNode tail = dummyTail.prev, tailPrev = tail.prev;
                tailPrev.next = dummyTail;
                dummyTail.prev = tailPrev;
                return tail;
            }
        }

        private final HashMap<Integer, DLinkedListNode> nodeMap;
        private final DLinkedList dLinkedList;
        private final int capacity;

        private int size() {
            return nodeMap.size();
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            nodeMap = new HashMap<>();
            dLinkedList = new DLinkedList();
        }

        public int get(int key) {
            if (!nodeMap.containsKey(key)) {
                return -1;
            } else {
                DLinkedListNode curr = nodeMap.get(key);
                dLinkedList.moveToHead(curr);
                return curr.val;
            }
        }

        public void put(int key, int value) {
            if (nodeMap.containsKey(key)) {
                DLinkedListNode curr = nodeMap.get(key);
                curr.val = value;
                dLinkedList.moveToHead(curr);
            } else {
                DLinkedListNode newNode = new DLinkedListNode(key, value);
                nodeMap.put(key, newNode);
                dLinkedList.insertAtHead(newNode);
                if (size() > capacity) {
                    DLinkedListNode tail = dLinkedList.removeTail();
                    nodeMap.remove(tail.key);
                }
            }
        }
    }
}
