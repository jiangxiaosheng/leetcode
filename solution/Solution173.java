import java.util.ArrayList;
import java.util.List;

public class Solution173 {
    static class BSTIterator {

        List<Integer> list = new ArrayList<>();
        int idx = 0;

        public BSTIterator(TreeNode root) {
            buildHelper(root);
        }

        private void buildHelper(TreeNode root) {
            if (root == null) return;
            buildHelper(root.left);
            list.add(root.val);
            buildHelper(root.right);
        }

        public int next() {
            return list.get(idx++);
        }

        public boolean hasNext() {
            return idx < list.size();
        }
    }
}
