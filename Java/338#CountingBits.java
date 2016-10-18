public class Solution {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        ret[0] = 0;
        for(int i = 1, j = 2; i <= num; j *= 2) {
        	for(int k = 0; i <= num && i < j; ++i, ++k) {
        		ret[i] = ret[k] + 1;
        	}
        }

        return ret;
    }
}