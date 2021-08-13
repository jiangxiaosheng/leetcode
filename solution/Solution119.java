import java.util.ArrayList;
import java.util.List;

public class Solution119 {

    int[][] comb = new int[34][34];

    {
        comb[0][0] = 1;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res.add(c(rowIndex, i));
        }
        return res;
    }

    public int c(int n, int m) {
        if (n == 0) return comb[0][0];
        if (comb[m][n] != 0) return comb[m][n];
        for (int i = 1; i <= n; i++) {
            comb[0][i] = 1;
            for  (int j = 1; j <= n; j++) {
                if (j <= n / 2)
                    comb[j][i] = comb[j - 1][i - 1] + comb[j][i - 1];
                else
                    comb[j][i] = comb[n - j][i];
            }
        }
        return comb[m][n];
    }
}
