public class Solution {
    public int climbStairs(int n) {
    	int[] ret = new int[n + 2];
    	ret[0] = 1;
    	for(int i = 0; i < n; i++) {
    		ret[i + 1] += ret[i];
    		ret[i + 2] += ret[i];
    	}
    	return ret[n];
    }
}