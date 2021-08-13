public class Solution415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int c = 0, p1 = num1.length() - 1, p2 = num2.length() - 1, t;
        while (p1 >= 0 && p2 >= 0) {
            t = num1.charAt(p1) - '0' + num2.charAt(p2) - '0' + c;
            sb.append(t % 10);
            c = t / 10;
            p1--;
            p2--;
        }
        if (p1 != -1 || p2 != -1) {
            if (p1 == -1) {
                while (p2 >= 0) {
                    t = num2.charAt(p2) - '0' + c;
                    sb.append(t % 10);
                    c = t / 10;
                    p2--;
                }
            } else {
                while (p1 >= 0) {
                    t = num1.charAt(p1) - '0' + c;
                    sb.append(t % 10);
                    c = t / 10;
                    p1--;
                }
            }
        }
        if (c != 0)
            sb.append(c);
        return sb.reverse().toString();
    }
}
