public class Solution237 {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        while (next != null) {
            node.val = next.val;
            if (next.next == null) {
                node.next = null;
                return;
            }
            node = next;
            next = node.next;
        }
    }
}
