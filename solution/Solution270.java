public class Solution270 {
    public int closestValue(TreeNode root, double target) {
        return findHelper(root, target, 0);
    }

    private int findHelper(TreeNode root, double target, int prev) {
        if (root == null) return prev;
        if (Math.abs(target - root.val) < 1e-20) return root.val;
        if (target > root.val)
            return findHelper(root.right, target, root.val);
        else
            return findHelper(root.left, target, root.val);
    }
}
