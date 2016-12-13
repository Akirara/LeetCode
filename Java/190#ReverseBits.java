public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long[] pow = new long[32];
        long ln = n;
        if (ln < 0) {
            ln += 4294967296L;
        }
        pow[0] = 1;
        for (int i = 1; i < 32; i++) {
            pow[i] = 2 * pow[i - 1];
        }
        long reverse = 0;
        for (int i = 31; i >= 0; i--) {
            if (ln >= pow[i]) {
                ln -= pow[i];
                reverse += pow[31 - i];
            }
        }
        return (int) reverse;
    }
}