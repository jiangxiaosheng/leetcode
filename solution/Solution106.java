import java.util.HashMap;
import java.util.Map;

public class Solution106 {
    Map<Integer, Integer> pos = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            pos.put(inorder[i], i);
        }
        return helper(postorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode helper(int[] postorder, int[] inorder, int postLeft, int postRight, int inLeft, int inRight) {
        if (postLeft > postRight) return null;
        int inIndex = pos.get(postorder[postRight]);
        TreeNode r = new TreeNode(inorder[inIndex]);
        int size = inRight - inIndex;
        r.left = helper(postorder, inorder, postLeft, postRight - size - 1, inLeft, inIndex - 1);
        r.right = helper(postorder, inorder, postRight - size, postRight - 1, inIndex + 1, inRight);
        return r;
    }
}
