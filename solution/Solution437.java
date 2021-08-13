import java.util.HashMap;
import java.util.Map;

public class Solution437 {

    int cnt = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        dfs(root, targetSum, 0, preSumMap);
        return cnt;
    }

    private void dfs(TreeNode root, int targetSum, int currSum, Map<Integer, Integer> preSumMap) {
        if (root == null) return;
        currSum += root.val;
        cnt += preSumMap.getOrDefault(currSum - targetSum, 0);
        preSumMap.put(currSum, preSumMap.getOrDefault(currSum, 0) + 1);
        dfs(root.left, targetSum, currSum, preSumMap);
        dfs(root.right, targetSum, currSum, preSumMap);
        preSumMap.put(currSum, preSumMap.get(currSum) - 1);
    }
}
