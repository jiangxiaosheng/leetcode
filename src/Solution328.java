public class Solution328 {
    //1->2->3->4->5->NULL
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, temp = even;
        while (even != null) {
            odd.next = odd.next.next;
            if (odd.next != null) {
                odd = odd.next;
            } else {
                break;
            }
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = temp;
        return head;
    }
}
