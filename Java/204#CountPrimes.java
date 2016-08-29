public class Solution {
    public int countPrimes(int n) {
    	boolean[] notPrime = new boolean[n];
    	int count = 0;
    	for(int i = 2; i < n; ++i) {
    		if(!notPrime[i]) {
    			++count;
    			for(int j = 2, tmp = i * j; tmp < n; ++j, tmp = i * j) {
    				notPrime[tmp] = true;
    			}
    		}
    	}
    	return count;
    }
}