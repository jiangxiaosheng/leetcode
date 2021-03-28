public class Solution67 {
    // 110, 1
    public String addBinary(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        if (a.length() < b.length()) {
            String t = b;
            b = a;
            a = t;
        }
        for (int i = 0; i < b.length(); i++) {
            int[] t = calc(a.charAt(a.length() - i - 1), b.charAt(b.length() - i - 1), carry);
            carry = t[1];
            sum.append(t[0]);
        }
        for (int i = b.length(); i < a.length(); i++) {
            int[] t = calc(a.charAt(a.length() - i - 1), '0', carry);
            carry = t[1];
            sum.append(t[0]);
        }
        if (carry == 1)
            sum.append(1);
        return sum.reverse().toString();
    }

    private int[] calc(char a, char b, int carry) {
        int sum = a - '0' + b - '0' + carry;
        return new int[]{sum % 2, sum / 2};
    }
}
