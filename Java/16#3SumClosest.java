public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;

        if(len == 0)
        	return 0;
        if(len == 1)
        	return nums[0];
        if(len == 2)
        	return nums[0] + nums[1];
        if(len == 3)
        	return nums[0] + nums[1] + nums[2];

        int sum = nums[0] + nums[1] + nums[2];
        int tmp = sum > target ? sum - target : target - sum;
        int ret = sum; 
        Arrays.sort(nums);
        for(int i = 0; i < len - 2; i++) {
        	int low = i + 1;
        	int high = len - 1;

        	while(low < high) {
        		sum = nums[i] + nums[low] + nums[high];
        		if(sum == target)
        			return sum;
        		else if(sum > target) {
        			if(sum - target < tmp) {
        				tmp = sum - target;
        				ret = sum;
        			}
        			high--;
        		}
        		else {
        			if(target - sum < tmp) {
        				tmp = target -sum;
        				ret = sum;
        			}
        			low++;
        		}
        	}
        }
        return ret;
    }
}