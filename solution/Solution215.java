import java.util.Random;

public class Solution215 {

    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return nums[quickSelect(nums, k, 0, nums.length - 1)];
    }

    private int quickSelect(int[] arr, int k, int i, int j) {
        int idx = partition(arr, i, j);
        if (idx == k) return k;
        else
            return idx > k ? quickSelect(arr, k, i, idx - 1) : quickSelect(arr, k, idx + 1, j);
    }

    private int partition(int[] arr, int l, int h) {
        int pivot = random.nextInt(h - l + 1) + l;
        swap(arr, pivot, h);
        int x = arr[h], i = l - 1;
        for (int j = l; j < h; j++) {
            if (arr[j] <= x)
                swap(arr, ++i, j);
        }
        swap(arr, i + 1, h);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }
}
