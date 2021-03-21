public class Solution645 {
    // [3, 2, 2]
    public int[] findErrorNums(int[] nums) {
        int[] bucket = new int[nums.length - 1];
        for (int i : nums) {
            bucket[i - 1]++;
        }
        int dup = 0, missing = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == 0)
                missing = i + 1;
            if (bucket[i] > 1)
                dup = i + 1;
        }
        return new int[]{dup, missing};
    }
}
