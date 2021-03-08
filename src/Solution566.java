public class Solution566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length, count;
        if (r * c != m * n) return nums;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                count = i * c + j;
                int originX = count / n, originY = count % n;
                res[i][j] = nums[originX][originY];
            }
        }
        return res;
    }
}
