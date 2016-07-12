public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - k -1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
        return;
    }

    public void reverse(int[] nums, int low, int high) {
    	while(low < high) {
    		int tmp = nums[low];
    		nums[low] = nums[high];
    		nums[high] = tmp;
    		low++;
    		high--;
    	}
    	return;
    }
}


public class Solution {
	public void rotate(int[] nums, int k) {
	    if(nums.length == 0 || k % nums.length == 0) return;
	    int start = 0, i = start, curNum = nums[i], count = 0;
	    while(count++ < nums.length){
	        int tmp = nums[i = (i + k) % nums.length];
	        nums[i] = curNum;
	        curNum = i == start ? nums[i = ++start] : tmp;
	    }
	}
}


public class Solution {
	public void rotate(int[] nums, int k) {
	    if(nums.length == 0 || k % nums.length == 0) return;
	    int start = 0, i = start, curNum = nums[i], count = 0;
	    while(count < nums.length){
	        i = (i + k) % nums.length;
	        int tmp = nums[i];
	        nums[i] = curNum;
	        if(i == start){
	            start++;
	            i = start;
	            curNum = nums[i];
	        }
	        else curNum = tmp;
	        count++;
	    }
	}
}