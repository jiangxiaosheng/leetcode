public class Solution157 extends Reader4 {
    // TODO
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int tmp;
        int length = 0;
        char[] bufTmp = new char[4];
        while ((tmp = read4(bufTmp)) != 0) {
            for (int i = 0; i < tmp && length < n; i++) {
                buf[length] = bufTmp[i];
                length++;
            }

        }
        return length;
    }

}
