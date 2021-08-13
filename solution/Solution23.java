import java.util.*;

public class Solution23 {
    static class Wrapper implements Comparable<Wrapper> {
        int val;
        ListNode node;

        Wrapper(int v, ListNode n) {
            val = v;
            node = n;
        }

        @Override
        public int compareTo(Wrapper o) {
            return this.val - o.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Wrapper> pq = new PriorityQueue<>();
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(new Wrapper(head.val, head));
            }
        }

        ListNode head = new ListNode(), tail = head;
        while (!pq.isEmpty()) {
            Wrapper w = pq.poll();
            tail.next = new ListNode(w.val);
            tail = tail.next;

            if (w.node.next != null) {
                w.node = w.node.next;
                w.val = w.node.val;
                pq.offer(w);
            }
        }
        return head.next;
    }
}
