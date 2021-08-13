public class Solution530 {

    int minDiff = Integer.MAX_VALUE;
    int pre = -1;

    public int minDiffInBST(TreeNode root) {
        inTravel(root);
        return minDiff;
    }

    private void inTravel(TreeNode root) {
        if (root == null) return;
        inTravel(root.left);
        if (pre != -1) {
            minDiff = Math.min(minDiff, root.val - pre);
        }
        pre = root.val;
        inTravel(root.right);
    }
}
