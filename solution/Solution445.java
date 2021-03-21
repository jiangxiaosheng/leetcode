import java.util.Stack;

public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        for (ListNode curr = l1; curr != null; curr = curr.next)
            s1.push(curr.val);
        for (ListNode curr = l2; curr != null; curr = curr.next)
            s2.push(curr.val);

        int inc = 0;
        ListNode head = new ListNode(), curr = null;
        while (!s1.empty() || !s2.empty()) {
            int n1 = s1.isEmpty() ? 0 : s1.pop();
            int n2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = n1 + n2 + inc;
            ListNode prev = new ListNode(sum % 10);
            inc = sum / 10;
            head.next = prev;
            prev.next = curr;
            curr = prev;
        }
        if (inc == 1) {
            ListNode one = new ListNode(1);
            one.next = head.next;
            return one;
        }
        return head.next;
    }
}
