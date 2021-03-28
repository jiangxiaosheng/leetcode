public class Solution59 {

    private final int[] LEFT = {0, -1}, RIGHT = {0, 1}, UP = {-1, 0}, DOWN = {1, 0};
    private int[] direction = RIGHT;
    int n;
    boolean[][] visited;

    public int[][] generateMatrix(int n) {
        this.n = n;
        int[][] res = new int[n][n];
        visited = new boolean[n][n];
        int idx = 0;
        int[] pos = {0, 0};
        while (idx < n * n) {
            res[pos[0]][pos[1]] = idx + 1;
            visited[pos[0]][pos[1]] = true;
            validAndTurnRight(pos);
            idx++;
        }
        return res;
    }

    private void validAndTurnRight(int[] pos) {
        if (direction == DOWN) {
            if (pos[0] + 1 >= n || visited[pos[0] + 1][pos[1]]) {
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
