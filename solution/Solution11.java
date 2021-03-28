public class Solution11 {
    public int maxArea(int[] height) {
        int maxArea = -1;
        for (int i = 0, j = height.length - 1 - i; i < j; ) {
            maxArea = Math.max(maxArea, (Math.min(height[j], height[i]) * (j - i)));
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return maxArea;
    }
}
