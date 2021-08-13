import java.util.Arrays;

public class Solution73 {
    // with space complexity O(m+n)
//    public void setZeroes(int[][] matrix) {
//        int m = matrix.length, n = matrix[0].length;
//        boolean[] rows = new boolean[m], cols = new boolean[n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 0)
//                    rows[i] = cols[j] = true;
//            }
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++)
//                if (rows[i] || cols[j])
//                    matrix[i][j] = 0;
//        }
//    }

    // with space complexity O(1)
    public void setZeroes(int[][] matrix) {
        boolean flagRow = false, flagCol = false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if (i == 0) flagRow = true;
                    if (j == 0) flagCol = true;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        if (flagRow) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (flagCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
