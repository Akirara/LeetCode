public class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = {1, 1, 2, 6, 24, 120, 720, 5760, 51840};
        int[] flag = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for(int i = n - 1; i >= 0; i--) {
        	num = k / fact[i];
        	k = k % fact[i];
        	if(k == 0) {
        		k = fact[i];
        	}
        	else {
        		num++;
        	}
        	for(int j = 1, count = 0; j <= 9; j++) {
        		if(flag[j] == 0)
        			count++;
        		if(count == num) {
      				flag[j] = 1;
      				sb.append(j);
      				break;
      			}
        	}
        } 
        return sb.toString();
    }
}