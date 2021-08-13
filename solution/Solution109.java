public class Solution109 {

    ListNode headGlobal;

    public TreeNode sortedListToBST(ListNode head) {
        headGlobal = head;
        int len = getLength(head);
        return buildTree(head, 0, len - 1);
    }

    private int getLength(ListNode head) {
        int len = 0;
        for (; head != null; len++, head = head.next);
        return len;
    }

    private TreeNode buildTree(ListNode head, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) >> 1;
        TreeNode leftNode = buildTree(head, left, mid - 1);
        TreeNode root = new TreeNode(headGlobal.val);
        headGlobal = headGlobal.next;
        TreeNode rightNode = buildTree(head, mid + 1, right);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
