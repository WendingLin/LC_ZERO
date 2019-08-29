/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int pos = 0;
        for(int i = 0; i<n; i+=4){
            char[] temp = new char[4];
            int len = read4(temp);
            for(int j = 0; j<len && i+j<n; j++){
                buf[i+j] = temp[j];
            }
            if(len<4) return Math.min(i+len, n);
        }
        return n;
    }
}
