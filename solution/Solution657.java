public class Solution657 {
    public boolean judgeCircle(String moves) {
        int[] pos = new int[]{0, 0};
        for (char m : moves.toCharArray()) {
            switch (m) {
                case 'R':
                    pos[0]++; break;
                case 'L':
                    pos[0]--; break;
                case 'U':
                    pos[1]++; break;
                case 'D':
                    pos[1]--; break;
            }
        }
        return pos[0] == 0 && pos[1] == 0;
    }
}
