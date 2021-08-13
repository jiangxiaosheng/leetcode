public class Solution333 {

    static class Node {
        int l, r;
        int cnt;

        Node(int l, int r, int cnt) {
            this.l = l;
            this.r = r;
            this.cnt = cnt;
        }
    }

    int max = 1;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    private Node dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new Node(root.val, root.val, 1);
        }
        int l = root.val, r = root.val;
        int cnt = 1;
        boolean valid = true;
        if (root.left != null) {
            Node node = dfs(root.left);
            if (node.cnt != -1 && node.r < root.val) {
                cnt += node.cnt;
                l = node.l;
            } else {
                valid = false;
            }
        }
        if (root.right != null) {
            Node node = dfs(root.right);
            if (node.cnt != -1 && node.l > root.val) {
                cnt += node.cnt;
                r = node.r;
            } else {
                valid = false;
            }
        }
        if (valid) {
            max = Math.max(max, cnt);
            return new Node(l, r, cnt);
        }
        return new Node(-1, -1, -1);
    }
}
