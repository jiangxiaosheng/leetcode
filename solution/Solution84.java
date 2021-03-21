import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, -1});
        for (int i = 0; i <= heights.length; i++) {
            int height;
            if (i != heights.length)
                height = heights[i];
            else
                height = 0;
            while (height < stack.peek()[0]) {
                int[] curr = stack.pop(), prev = stack.peek();
                while (curr[0] == prev[0]) {
                    curr = stack.pop();
                    prev = stack.peek();
                }
                int area = curr[0] * (i - prev[1] - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(new int[]{height, i});
        }
        return maxArea;
    }
}
