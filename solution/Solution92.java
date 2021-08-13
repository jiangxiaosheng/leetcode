public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preLeft, preRight, succ, dummy = new ListNode(), curr = dummy;
        dummy.next = head;
        for (int i = 1; i < left; i++) {
            curr = curr.next;
        }
        preLeft = curr;
        curr = curr.next;
        preRight = curr;
        for (int i = 0; i < right - left; i++) {
            curr = curr.next;
        }
        succ = curr.next;
        curr.next = null;
        preLeft.next = reverseList(preRight);
        preRight.next = succ;
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode tmp = null, curr = head, p;
        while (curr != null) {
            p = curr.next;
            curr.next = tmp;
            tmp = curr;
            curr = p;
        }
        return tmp;
    }
}
