public class Interview1710 {
    // 1,2,5,9,5,9,5,5,5
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for (int n : nums) {
            if (count == 0) candidate = n;
            if (n == candidate)
                count++;
            else
                count--;
        }
        int cnt = 0;
        for (int n : nums) {
            if (n == candidate) cnt++;
        }
        if (cnt > nums.length / 2)
            return candidate;
        else
            return -1;
    }
}
