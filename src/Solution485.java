public class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currLength = 0;
        for (int n : nums) {
            if (n == 1)
                currLength++;
            else {
                max = Math.max(max, currLength);
                currLength = 0;
            }
        }
        return Math.max(max, currLength);
    }
}
