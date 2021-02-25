public class Solution328 {
    //1->2->3->4->5->NULL
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, even = head.next;
        while (even != null) {
            odd.next = even.next;
            even.next = even.next.next;
            odd.next.next = even;

        }
    }
}
