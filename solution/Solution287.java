public class Solution287 {
    public int findDuplicate(int[] nums) {
        boolean[] a = new boolean[nums.length];
        for (int num : nums) {
            a[num - 1] = !a[num - 1];
            if (!a[num - 1])
                return num;
        }
        return -1;
    }
}
