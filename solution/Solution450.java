public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) return deleteHelper(root);
        TreeNode curr = root, prev = null;
        while (curr != null) {
            if (curr.val == key) break;
            prev = curr;
            if (curr.val < key) curr = curr.right;
            else curr = curr.left;
        }
        if (curr == null) return root;
        System.out.println(prev.val + " " + curr.val);
        if (prev.right == null || key != prev.right.val) {
            prev.left = deleteHelper(prev.left);
        } else {
            prev.right = deleteHelper(prev.right);
        }
        return root;
    }

    private TreeNode deleteHelper(TreeNode root) {
        if (root.left != null && root.right != null) {
            TreeNode pre = root, next = root.left;
            while (next.right != null) {
                pre = next;
                next = next.right;
            }
            if (pre == root) {
                pre.left = next.left;
            } else {
                pre.right = null;
            }
            root.val = next.val;
            return root;
        } else if (root.left != null) {
            return root.left;
        } else if (root.right != null) {
            return root.right;
        } else {
            return null;
        }
    }
}
