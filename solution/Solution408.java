public class Solution408 {
    // s = "internationalization", abbr = "i12iz4n"
    public boolean validWordAbbreviation(String word, String abbr) {
        int idx = 0;
        String val;
        while (idx < abbr.length()) {
            val = extract(word, idx);
            if (val.charAt(0) >= '0' && val.charAt(0) <= '9') {
                idx += Integer.parseInt(val);
            } else {
                if (!word.startsWith(val, idx)) {
                    return false;
                }
                idx += val.length();
            }
        }
        return true;
    }

    public String extract(String s, int start) {
        StringBuilder sb = new StringBuilder();
        int i = start;
        while (i < s.length() && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
            sb.append(s.charAt(i));
            i++;
        }
        i = start;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
