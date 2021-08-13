public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, dummy = new ListNode(), head = dummy;
        int carry = 0;
        while (p1 != null || p2 != null) {
            ListNode t;
            if (p1 == null) {
                t = new ListNode((p2.val + carry) % 10);
                carry = (p2.val + carry) / 10;
                p2 = p2.next;
            } else if (p2 == null) {
                t = new ListNode((p1.val + carry) % 10);
                carry = (p1.val + carry) / 10;
                p1 = p1.next;
            } else {
                t = new ListNode((p1.val + p2.val + carry) % 10);
                carry = (p1.val + p2.val + carry) / 10;
                p1 = p1.next;
                p2 = p2.next;
            }
            head.next = t;
            head = head.next;
        }
        if (carry == 1) {
            head.next = new ListNode(1);
        }
        return dummy.next;
    }
}
