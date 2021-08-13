public class Offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode h1 = headA, h2 = headB;
        boolean flag1 = false, flag2 = false;
        while (h1 != h2) {
            if (h1.next == null) {
                if (flag1) return null;
                h1 = headB;
                flag1 = true;
            } else {
                h1 = h1.next;
            }
            if (h2.next == null) {
                if (flag2) return null;
                h2 = headA;
                flag2 = true;
            } else {
                h2 = h2.next;
            }
        }
        return h1;
    }
}
