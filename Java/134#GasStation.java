public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int len = gas.length;
    	if(len == 0)
    		return -1;
    	int[] diff = new int[len];
    	for(int i = 0; i < len; ++i)
    		diff[i] = gas[i] - cost[i];
    	int start = 0;
    	int sum = 0;
    	for(int count = 0; count < len; ++count) {
    		sum += diff[(start + count) % len];
    		while(sum < 0) {
    			sum -= diff[start];
    			if(++start == len)
    				return -1;
    			--count;
    		}
    	}
    	return start;
    }
}