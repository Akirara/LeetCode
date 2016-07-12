public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}



public class Solution {
    public int findKthLargest(int[] nums, int k) {
    	quicksort(nums, 0, nums.length - 1);
    	return nums[nums.length - k];
    }

    public void quicksort(int[] nums, int low, int high) {
    	if(low >= high)
    		return;
    	int pivot = nums[low];
    	int l = low;
    	int h = high;
    	while(l < h) {
    		while(l < h && nums[h] >= pivot)
    			h--;
    		nums[l] = nums[h];
    		while(l < h && nums[l] <= pivot)
    			l++;
    		nums[h] = nums[l];
    	}
    	nums[h] = pivot;
    	quicksort(nums, low, h - 1);
    	quicksort(nums, h + 1, high);
    }
}