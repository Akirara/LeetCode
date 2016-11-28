public class Solution {
    public void moveZeroes(int[] nums) {
        int offset = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                offset++;
            } else if (offset != 0) {
                nums[i - offset] = nums[i];
            }
        }
        for (int i = len - offset; i < len; i++) {
            nums[i] = 0;
        }
    }
}