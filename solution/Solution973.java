import java.util.Arrays;
import java.util.Random;

public class Solution973 {

    Random random = new Random();

    public int[][] kClosest(int[][] points, int k) {
        int idx = quickSelect(points, k, 0, points.length - 1);
        int[][] ans = new int[k][];
        System.arraycopy(points, 0, ans, 0, k);
        return ans;
    }

    private int quickSelect(int[][] arr, int k, int i, int j) {
        int idx = partition(arr, i, j);
        if (idx == k - 1) return idx;
        else return idx > k - 1 ? quickSelect(arr, k, i, idx - 1) : quickSelect(arr, k, idx + 1, j);
    }

    private int partition(int[][] arr, int l, int h) {
        int pivot = random.nextInt(h - l + 1) + l;
        swap(arr, pivot, h);
        int x = distance(arr[h]), i = l - 1;
        for (int j = l; j < h; j++) {
            if (distance(arr[j]) <= x)
                swap(arr, ++i, j);
        }
        swap(arr, i + 1, h);
        return i + 1;
    }

    private void swap(int[][] arr, int i, int j) {
        if (i == j) return;
        int[] t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

    private int distance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}
