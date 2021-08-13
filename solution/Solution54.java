import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    private final int[] LEFT = {0, -1}, RIGHT = {0, 1}, UP = {-1, 0}, DOWN = {1, 0};
    private int[] direction = RIGHT;
    private int m, n;
    boolean[][] visited;

    public List<Integer> spiralOrder(int[][] matrix) {
        m = matrix.length; n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        visited = new boolean[m][n];
        int idx = 0;
        int[] pos = {0, 0};
        while (idx < m * n) {
            res.add(matrix[pos[0]][pos[1]]);
            visited[pos[0]][pos[1]] = true;
            validAndTurnRight(pos);
            idx++;
        }
        return res;
    }

    private void validAndTurnRight(int[] pos) {
        if (direction == DOWN) {
            if (pos[0] + 1 >= m || visited[pos[0] + 1][pos[1]]) {
                direction = LEFT;
            }
        } else if (direction == UP) {
            if (pos[0] - 1 < 0 || visited[pos[0] - 1][pos[1]]) {
                direction = RIGHT;
            }
        } else if (direction == LEFT) {
            if (pos[1] - 1 < 0 || visited[pos[0]][pos[1] - 1]) {
                direction = UP;
            }
        } else {
            if (pos[1] + 1 >= n || visited[pos[0]][pos[1] + 1]) {
                direction = DOWN;
            }
        }
        pos[0] += direction[0];
        pos[1] += direction[1];
    }
}
