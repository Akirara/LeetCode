public class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int max = 0;
        int min = 0;
        for(int i = 0; i < len; ++i) {
        	left[i] = max;
        	if(height[i] > max) {
        		max = height[i];
        	}
        }
        max = 0;
        for(int i = len - 1; i >=0; --i) {
        	right[i] = max;
        	if(height[i] > max) {
        		max = height[i];
        	}
        }
        max = 0;
        for(int i = 0; i < len; ++i) {
        	min = Math.min(left[i], right[i]) - height[i];
        	if(min > 0) {
        		max += min; 
        	}
        }
        return max;
    }
}

/*
*	O(1) space
*/

public class Solution {
    public int trap(int[] height) {
    	int maxLeft = 0;
    	int maxRight = 0;
    	int res = 0;
    	int left = 0;
    	int right = height.length - 1;
    	while(left <= right) {
    		if(height[left] < height[right]) {
    			if(height[left] > maxLeft) {
    				maxLeft = height[left];
    			}
    			else {
    				res += maxLeft - height[left];
    			}
    			++left;
    		}
    		else {
    			if(height[right] > maxRight) {
    				maxRight = height[right];
    			}
    			else {
    				res += maxRight - height[right];
    			}
    			--right;
    		}
    	}
    	return res;
    }
}