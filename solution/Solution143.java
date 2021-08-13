public class Solution143 {
    public void reorderList(ListNode head) {
        if (head.next == null) return;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode lastHalf = slow.next;
        slow.next = null;
        lastHalf = reverseList(lastHalf);
        printLinkedList(lastHalf);
        ListNode p1 = head, p2 = lastHalf, newHead = new ListNode(-1), curr = newHead;
        while (p1 != null && p2 != null) {
            curr.next = p1;
            curr = curr.next;
            curr.next = p2;
            curr = curr.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 != null) curr.next = p1;
    }

    public static void printLinkedList(ListNode h) {
        if (null == h) return;
        ListNode cur = h;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.print("\b\b\n");
    }

    private ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null, tmp;
        while (curr != null) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}
