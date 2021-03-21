import java.util.Arrays;

public class Solution303 {
    static class NumArray {

        private final int[] sums;

        // [-2, 0, 3, -5, 2, -1]
        public NumArray(int[] nums) {
            sums = new int[nums.length];
            int sum = 0;
            for (int i = 0; i < sums.length; i++) {
                sum += nums[i];
                sums[i] = sum;
            }
            System.out.println(Arrays.toString(sums));
        }

        public int sumRange(int i, int j) {
            return sums[j] - (i == 0 ? 0 : sums[i - 1]);
        }
    }
}
