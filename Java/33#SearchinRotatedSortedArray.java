public class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0)
        	return -1;
        return binary(nums, target, 0, len - 1);
    }

    public int binary(int[] nums, int target, int low, int high) {
        if(low > high)
            return -1;
        int mid = (low + high) / 2;
        if(nums[mid] == target)
            return mid;
        else if(target < nums[mid]) {
            if(nums[low] <= nums[mid] && target < nums[low])
                return binary(nums, target, mid + 1, high);
            else
                return binary(nums, target, low, mid - 1);
        }
        else {
            if(nums[mid] <= nums[high] && target > nums[high])
                return binary(nums, target, low, mid - 1);
            else
                return binary(nums, target, mid + 1, high);
        }
    }
}