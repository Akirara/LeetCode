public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;

        if(len < 2)
        	return;

        for(int i = len - 1; i > 0; i--) {
            if(nums[i] > nums[i - 1]) {
                for(int j = len - 1; j >= i; j--) {
                    if(nums[j] > nums[i - 1]) {
                        int tmp = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = tmp;

                        int low = i;
                        int high = len - 1;
                        while(low < high) {
                            tmp = nums[low];
                            nums[low] = nums[high];
                            nums[high] = tmp;
                            low++;
                            high--;
                        }
                        return;
                    }
                }
            }
        }
        int low = 0;
        int high = len - 1;
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