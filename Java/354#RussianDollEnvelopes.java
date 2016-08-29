public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0)
        	return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
        	public int compare(int[] x, int[] y) {
        		return x[0] - y[0];
        	}
        });
       	int[] max = new int[envelopes.length];
       	int ret = 0;
       	for(int i = 0; i < envelopes.length; ++i) {
       		max[i] = 1;
       		for(int j = 0; j < i; ++j) {
       			if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1] && max[j] >= max[i]) {
       				max[i] = max[j] + 1;
       			}
       		}
       		if(max[i] > ret) {
       			ret = max[i];
       		}
       	}
       	return ret;
    }
}


/**
*	nlogn solution
*/
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
	    if(envelopes == null || envelopes.length == 0 
	       || envelopes[0] == null || envelopes[0].length != 2)
	        return 0;
	    Arrays.sort(envelopes, new Comparator<int[]>(){
	        public int compare(int[] arr1, int[] arr2){
	            if(arr1[0] == arr2[0])
	                return arr2[1] - arr1[1];
	            else
	                return arr1[0] - arr2[0];
	       } 
	    });
	    int dp[] = new int[envelopes.length];
	    int len = 0;
	    for(int[] envelope : envelopes){
	        int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
	        if(index < 0)
	            index = -(index + 1);
	        dp[index] = envelope[1];
	        if(index == len)
	            len++;
	    }
	    return len;
	}
}