import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution200 {
    // dfs version
//    private void dfs(char[][] grid, int r, int c, int rs, int cs) {
//        if (r < 0 || r >= rs || c < 0 || c >= cs || grid[r][c] == '0') return;
//        grid[r][c] = '0';
//        dfs(grid, r - 1, c, rs, cs);
//        dfs(grid, r + 1, c, rs, cs);
//        dfs(grid, r, c - 1, rs, cs);
//        dfs(grid, r, c + 1, rs, cs);
//    }
//
//    public int numIslands(char[][] grid) {
//        if (grid == null || grid.length == 0) {
//            return 0;
//        }
//        int rows = grid.length, cols = grid[0].length;
//        int count = 0;
//        for (int r = 0; r < rows; r++) {
//            for (int c = 0; c < cols; c++) {
//                if (grid[r][c] == '1') {
//                    dfs(grid, r, c, rows, cols);
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    // bfs version
//    public int numIslands(char[][] grid) {
//        if (grid == null || grid.length == 0) {
//            return 0;
//        }
//        int rows = grid.length, cols = grid[0].length;
//        Queue<Integer> queue = new LinkedList<>();
//        int count = 0;
//        for (int r = 0; r < rows; r++) {
//            for (int c = 0; c < cols; c++) {
//                if (grid[r][c] == '1') {
//                    int idx = r * cols + c;
//                    queue.offer(idx);
//                    while (!queue.isEmpty()) {
//                        int pos = queue.poll();
//                        int x = pos / cols, y = pos % cols;
//                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
//                            queue.offer((x - 1) * cols + y);
//                            grid[x - 1][y] = '0';
//                        }
//                        if (x + 1 < rows && grid[x + 1][y] == '1') {
//                            queue.offer((x + 1) * cols + y);
//                            grid[x + 1][y] = '0';
//                        }
//                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
//                            queue.offer(x * cols + y - 1);
//                            grid[x][y - 1] = '0';
//                        }
//                        if (y + 1 < cols && grid[x][y + 1] == '1') {
//                            queue.offer(x * cols + y + 1);
//                            grid[x][y + 1] = '0';
//                        }
//                    }
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    static class UFSet {
        int count;
        int[] parent;
        int[] rank;

        public UFSet(char[][] grid) {
            count = 0;
            int rows = grid.length, cols = grid[0].length;
            parent = new int[rows * cols];
            rank = new int[rows * cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == '1') {
                        parent[r * cols + c] = r * cols + c;
                        count++;
                    }
                    rank[r * cols + c] = 1;
                }
            }
        }

        public int count() {
            return count;
        }

        public int find(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int a, int b) {
            int roota = find(a), rootb = find(b);
            if (roota == rootb) return;
            if (rank[roota] > rank[rootb]) {
                rank[roota] += rank[rootb];
                parent[rootb] = roota;
            } else {
                rank[rootb] += rank[roota];
                parent[roota] = rootb;
            }
            count--;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        UFSet ufSet = new UFSet(grid);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    int idx = r * cols + c;
                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                        ufSet.union(idx, (r - 1) * cols + c);
                    }
                    if (r + 1 < rows && grid[r + 1][c] == '1') {
                        ufSet.union(idx, (r + 1) * cols + c);
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                        ufSet.union(idx, r * cols + c - 1);
                    }
                    if (c + 1 < cols && grid[r][c + 1] == '1') {
                        ufSet.union(idx, r * cols + c + 1);
                    }
                }
            }
        }
        return ufSet.count();
    }

}
