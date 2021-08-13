public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] rowOccurrence = new int[9][9];
        int[][] colOccurrence = new int[9][9];
        int[][] boxOccurrence = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int ele = board[i][j] - '1';
                if (rowOccurrence[i][ele] != 0) return false;
                rowOccurrence[i][ele]++;
                if (colOccurrence[j][ele] != 0) return false;
                colOccurrence[j][ele]++;
                int boxId = (i / 3) * 3 + j / 3;
                if (boxOccurrence[boxId][ele] != 0) return false;
                boxOccurrence[boxId][ele]++;
            }
        }
        return true;
    }
}
