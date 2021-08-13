import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int maxLength = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int currMax = 1, currN = n;
                while (set.contains(currN + 1)) {
                    currMax += 1;
                    currN += 1;
                }
                maxLength = Math.max(maxLength, currMax);
            }
        }
        return maxLength;
    }
}
