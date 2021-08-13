import java.util.HashMap;
import java.util.Map;

public class Solution105 {
    Map<Integer, Integer> pos = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            pos.put(inorder[i], i);
        }

        return helper(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) return null;

        int inIndex = pos.get(preorder[preLeft]);
        TreeNode r = new TreeNode(inorder[inIndex]);
        r.left = helper(preorder, inorder, preLeft + 1, preLeft + inIndex - inLeft, inLeft, inIndex - 1);
        r.right = helper(preorder, inorder, preLeft + inIndex - inLeft + 1, preRight, inIndex + 1, inRight);

        return r;
    }
}
