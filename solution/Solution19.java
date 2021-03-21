public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        for (int i = 0; i < n; i++)
            fast = fast.next;
        if (fast == null)
            return head.next;
        else
            fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

//    /**
//     * utilizes dummy node in front of the head
//     */
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dummy = new ListNode();
//        dummy.next = head;
//        ListNode slow = dummy, fast = head;
//        for (int i = 0; i < n; i++)
//            fast = fast.next;
//        while (fast != null) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        slow.next = slow.next.next;
//        return dummy.next;
//    }
}
