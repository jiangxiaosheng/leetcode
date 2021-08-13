import java.util.List;

public class BST {
    private TreeNode root;
    private int maxValue;
    private TreeNode maxNode;

    public BST() {
        root = null;
        maxValue = Integer.MIN_VALUE;
        maxNode = null;
    }

    public TreeNode getRoot() { return root; }

    public void put(int val) {
        if (root == null) {
            root = put(null, val);
            maxValue = val;
            maxNode = root;
        } else if (val >= maxValue) {
            maxNode.right = new TreeNode(val);
            maxValue = val;
            maxNode = maxNode.right;
        } else {
            put(root, val);
        }
    }

    private TreeNode put(TreeNode node, int val) {
        if (node == null)  {
            return new TreeNode(val);
        }
        if (node.val > val) {
            node.left = put(node.left, val);
        } else {
            node.right = put(node.right, val);
        }
        return node;
    }
}
