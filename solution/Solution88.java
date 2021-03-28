public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1, i1 = m - 1, i2 = n - 1;
        while (idx >= 0) {
            if (i1 == -1)
                nums1[idx--] = nums2[i2--];
            else if (i2 == -1)
                nums1[idx--] = nums1[i1--];
            else if (nums1[i1] > nums2[i2])
                nums1[idx--] = nums1[i1--];
            else
                nums1[idx--] = nums2[i2--];
        }
    }
}
