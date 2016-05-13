public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;
        int len = nums.length;
        if(len < 1)
        	return ret;
        int pos = binarySearch(nums, target, 0, len - 1);
        if(pos == -1)
        	return ret;
        ret[0] = pos;
        ret[1] = pos;
        while(ret[0] > 0 && nums[ret[0] - 1] == target)
        	ret[0]--;
        while(ret[1] < len - 1 && nums[ret[1] + 1] == target)
        	ret[1]++;
        return ret;
    }

    public int binarySearch(int[] nums, int target, int begin, int end) {
    	if((begin == end && nums[begin] != target) || begin > end)
    		return -1;
    	int mid = (begin + end) / 2;
    	if(nums[mid] == target) {
    		return mid;
    	}
    	else if(nums[mid] > target) {
    		return binarySearch(nums, target, begin, mid - 1);
    	}
    	else {
    		return binarySearch(nums, target, mid + 1, end);
    	}
    }
}