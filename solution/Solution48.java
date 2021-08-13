public class Solution48 {
    public void rotate(int[][] matrix) {
        int i = 0, n = matrix.length, j = n - 1;
        int t;
        while (i < j) {
            for (int idx = 0; idx < n; idx++) {
                t = matrix[idx][i];
                matrix[idx][i] = matrix[idx][j];
                matrix[idx][j] = t;
            }
            i++;
            j--;
        }
        i = 0;
        while (i < n - 1) {
            for (int idx = 0; idx < n - 1 - i; idx++) {
                t = matrix[n - 1 - idx][n - 1 - i];
                matrix[n - 1 - idx][n - 1 - i] = matrix[i][idx];
                matrix[i][idx] = t;
            }
            i++;
        }
    }
}
