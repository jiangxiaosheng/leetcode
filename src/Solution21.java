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

//    /**
//     * recursive version
//     */
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//        if (l1.val < l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l2.next, l1);
//            return l2;
//        }
//    }
}