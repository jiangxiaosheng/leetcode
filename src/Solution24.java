public class Solution24 {
//    /**
//     * recursive version
//     */
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode second = head.next;
//        head.next = swapPairs(second.next);
//        second.next = head;
//        return second;
//    }

    /**
     * iterative version
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head, second = first.next, temp;
        head = second;
        while (second != null) {
            first.next = second.next;
            second.next = first;
            if (first.next == null || first.next.next == null) break;
            second = first.next.next;
            temp = first.next;
            first.next = second;
            first = temp;
        }
        return head;
    }
}
