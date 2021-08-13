public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA, currB = headB;
        boolean hitTailA = false, hitTailB = false;
        while (currA != currB) {
            if (currA.next == null) {
                if (hitTailA) return null;
                hitTailA = true;
                currA = headB;
            } else {
                currA = currA.next;
            }
            if (currB.next == null) {
                if (hitTailB) return null;
                hitTailB = true;
                currB = headA;
            } else {
                currB = currB.next;
            }
        }
        return currA;
    }
}
