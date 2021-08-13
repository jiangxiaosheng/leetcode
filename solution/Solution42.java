import java.util.Stack;

public class Solution42 {
    // dp version
//    public int trap(int[] height) {
//        int n = height.length;
//        int[] leftMax = new int[n], rightMax = new int[n];
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            max = Math.max(height[i], max);
//            leftMax[i] = max;
//        }
//        max = 0;
//        for (int i = n - 1; i >= 0; i--) {
//            max = Math.max(height[i], max);
//            rightMax[i] = max;
//        }
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
//        }
//        return sum;
//    }

    // monotonous stack version
//    public int trap(int[] height) {
//        int ans = 0;
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < height.length; i++) {
//            while (!stack.empty() && height[i] > height[stack.peek()]) {
//                int top = stack.pop();
//                if (stack.empty()) break;
//                int left = stack.peek();
//                int width = i - left - 1;
//                int boundedHeight = Math.min(height[i], height[left]) - height[top];
//                ans += boundedHeight * width;
//            }
//            stack.push(i);
//        }
//        return ans;
//    }

    // double-pointer version
    public int trap(int[] height) {
        int n = height.length, left = 0, right = n - 1, ans = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
