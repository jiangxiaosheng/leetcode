import java.util.Vector;

public class ABSplit {
    public int solution(String S) {
        // write your code in Java SE 8
        int cntA = countA(S);
        if (cntA % 3 != 0)
            return 0;

        if (cntA == 0) {
            if (S.length() < 3) // if count of 'b' is less than 3, then no valid split
                return 0;
            // else, the possible splits = C(allPos, 2)
            int allPos = S.length() - 1;
            return factorial(allPos) / (factorial(2) * factorial(allPos - 2));
        }

        Vector<Integer> v = new Vector<>();
        char[] charArrayS = S.toCharArray();
        int lengthOfB = 0;
        for (char charArray : charArrayS) {
            if (charArray == 'a') {
                v.add(lengthOfB);
                lengthOfB = 0;
            } else {
                lengthOfB++;
            }
        }
        v.remove(0);

        int res = 1;
        for (Integer ele : v) {
            res *= (ele + 1);
        }

        return res;
    }

    private String[] solutionHelper(String S) {
        Vector<String> res = new Vector<>();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (cnt == 3) {
                cnt = 0;
                res.add(sb.toString());
                continue;
            }
            if (S.charAt(i) == 'a') {
                cnt++;
            }
            sb.append(S.charAt(i));
        }
        System.out.println(res);
        return (String[]) res.toArray();
    }

    private int countA(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a')
                cnt++;
        }
        return cnt;
    }

    private int factorial(int n) {
        if (n <= 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        ABSplit abSplit = new ABSplit();
        System.out.println(abSplit.solutionHelper("ababa b ababa b abaa"));
    }
}
