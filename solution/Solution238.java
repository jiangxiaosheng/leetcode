import java.util.Arrays;

public class Solution238 {
//    public int[] productExceptSelf(int[] nums) {
//        int size = nums.length;
//        int[] l = new int[size], r = new int[size];
//        l[0] = 1;
//        for (int i = 1; i < size; i++) {
//            l[i] = l[i - 1] * nums[i - 1];
//        }
//        r[size - 1] = 1;
//        for (int i = size - 2; i >= 0; i--) {
//            r[i] = r[i + 1] * nums[i + 1];
//        }
//        int[] res = new int[size];
//        for (int i = 0; i < size; i++) {
//            res[i] = l[i] * r[i];
//        }
//        return res;
//    }

    // optimized
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] res = new int[size];
        res[0] = 1;
        for (int i = 1; i < size; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int fac = 1;
        for (int i = size - 1; i >= 0; i--) {
            res[i] *= fac;
            fac *= nums[i];
        }
        return res;
    }
}