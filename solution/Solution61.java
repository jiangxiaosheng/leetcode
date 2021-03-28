public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) return head;
        if (head == null || head.next == null) return head;
        ListNode tail = head, newHead, newTail = head;
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        for (int i = 0; i < k; i++) {
            tail = tail.next;
        }
        while (tail.next != null) {
            tail = tail.next;
            newTail = newTail.next;
        }
        newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        return newHead;
    }
}
