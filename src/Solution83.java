public class Solution83 {
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode curr = head.next, prev = head;
//        int currValue = head.val;
//        prev.next = null;
//        while (curr != null) {
//            if (curr.val == currValue) {
//                curr = curr.next;
//            } else {
//                currValue = curr.val;
//                prev.next = curr;
//                prev = curr;
//                curr = curr.next;
//                prev.next = null;
//            }
//        }
//        return head;
//    }

    /**
     * recursive version
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
