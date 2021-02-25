class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h1 = l1, h2 = l2, result = new ListNode(), cur = result;
        while (h1 != null || h2 != null) {
            if (h1 == null) {
                cur.next = h2;
                h2 = h2.next;
            } else if (h2 == null) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                if (h1.val < h2.val) {
                    cur.next = h1;
                    h1 = h1.next;
                } else {
                    cur.next = h2;
                    h2 = h2.next;
                }
            }
            cur = cur.next;
        }
        return result.next;
    }
}