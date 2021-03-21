import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution79 {
    private final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m, n;

    private boolean check(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length; n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int idx, boolean[][] visited) {
        if (board[row][col] != word.charAt(idx))
            return false;
        if (word.length() == idx + 1)
            return true;
        visited[row][col] = true;
        for (int[] dir : direction) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (check(newRow, newCol) && !visited[newRow][newCol] && dfs(board, word, newRow, newCol, idx + 1, visited))
                return true;
        }
        visited[row][col] = false;
        return false;
    }
}
