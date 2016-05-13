public class Solution {
    public int maxArea(int[] height) {
    	int l = 0, r = height.length - 1, ret = 0, tmp = 0, hL = 0, hR = 0;

    	while(l < r) { 
    		hL = height[l];
    		hR = height[r];
    	   	tmp = (r - l) * ((hL > hR)?hR:hL);

    	   	if(tmp > ret) {
    	   		ret = tmp;
    	   	}

    		if(hL < hR) {
    			while(height[l] <= hL && l < r) {
    				l++;
    			}
    		}
    		else {
    			while(height[r] <= hR && l < r) {
    				r--;
    			} 
    		}
    	}

        return ret;
    }
}