public class Solution1530 {
    public int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;
        return dfs(root, distance).count;
    }

    private Pair dfs(TreeNode root, int distance) {
        int[] depth = new int[distance];
        if (root.left == null && root.right == null) {
            depth[0] = 1;
            return new Pair(depth, 0);
        }
        int[] leftDepths = new int[distance], rightDepths = new int[distance];
        int leftCnt = 0, rightCnt = 0;
        if (root.left != null) {
            Pair leftPair = dfs(root.left, distance);
            leftDepths = leftPair.depth;
            leftCnt = leftPair.count;
        }
        if (root.right != null) {
            Pair rightPair = dfs(root.right, distance);
            rightDepths = rightPair.depth;
            rightCnt = rightPair.count;
        }
        for (int i = 0; i < distance - 1; i++) {
            depth[i + 1] += leftDepths[i] + rightDepths[i];
        }
        int cnt = 0;
        for (int i = 0; i < distance; i++) {
            for (int j = 0; j < distance; j++) {
                if (i + j + 2 <= distance) cnt += leftDepths[i] * rightDepths[j];
                else break;
            }
        }
        return new Pair(depth, cnt + leftCnt + rightCnt);
    }

    static class Pair {
        int[] depth;
        int count;

        Pair(int[] d, int c) {
            depth = d;
            count = c;
        }
    }
}
