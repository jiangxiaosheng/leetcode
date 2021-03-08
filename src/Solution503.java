import java.util.Arrays;
import java.util.Stack;

public class Solution503 {
    // [1, 3, 5, 6, 1]
    public int[] nextGreaterElements(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.empty() && nums[i % n] > stack.peek()[0]) {
                res[stack.pop()[1]] = nums[i % n];
            }
            stack.push(new int[]{nums[i % n], i % n});
        }
        return res;
    }
}
