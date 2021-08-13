import java.util.ArrayList;
import java.util.List;

public class Solution99 {
    // TODO space complexity can be reduced to O(1)
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inTravel(root, list);
        int[] nodes = findTwoPos(list);
        recover(root, nodes[0], nodes[1], 2);
    }

    private void inTravel(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inTravel(root.left, list);
        list.add(root.val);
        inTravel(root.right, list);
    }

    private int[] findTwoPos(List<Integer> list) {
        int x = 0, y = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                x = i;
                y = i + 1;
                for (int j = i + 1; j < list.size() - 1; j++) {
                    if (list.get(j) > list.get(j + 1)) {
                        y = j + 1;
                        break;
                    }
                }
                break;
            }
        }
        return new int[]{list.get(x), list.get(y)};
    }

    private void recover(TreeNode root, int v1, int v2, int cnt) {
        if (root == null) return;
        if (root.val == v1 || root.val == v2) {
            root.val = root.val == v1 ? v2 : v1;
            if (--cnt == 0) return;
        }
        recover(root.left, v1, v2, cnt);
        recover(root.right, v1, v2, cnt);
    }
}
