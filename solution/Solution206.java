public class Solution206 {
    // recursive version
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode next = head.next;
//        ListNode newHead = reverseList(head.next);
//        head.next = null;
//        next.next = head;
//        return newHead;
//    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head, next = head.next, t;
        head.next = null;
        while (next != null) {
            t = next.next;
            next.next = prev;
            prev = next;
            next = t;
        }
        return prev;
    }
}
