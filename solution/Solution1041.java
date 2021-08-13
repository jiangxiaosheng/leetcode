public class Solution1041 {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, idx = 0;
        int[] dir = {0, 1, 0, -1, 0};
        for (char ins : instructions.toCharArray()) {
            switch (ins) {
                case 'G':
                   x += dir[idx];
                   y += dir[idx + 1];
                   break;
                case 'L':
                    idx = (idx + 3) % 4;
                    break;
                case 'R':
                    idx = (idx + 1) % 4;
                    break;
            }
        }
        return (x == 0 && y == 0) || idx != 0;
    }
}
