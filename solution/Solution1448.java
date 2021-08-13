//class TreeNode implements Comparable<TreeNode> {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//
//    TreeNode() {
//    }
//
//    public void setValue(int v) {
//        val = v;
//    }
//
//    @Override
//    public int compareTo(TreeNode o) {
//        return Integer.compare(val, o.val);
//    }
//}

public class Solution1448 {

    int cnt = 0;

    public int goodNodes(TreeNode root) {
        int curr = root.val;
        dfs(root, curr);
        return cnt;
    }

    private void dfs(TreeNode root, int curr) {
        if (root == null) return;
        if (curr <= root.val) {
            cnt++;
        }
        int t = Math.max(root.val, curr);
        dfs(root.left, t);
        dfs(root.right, t);
    }
}
