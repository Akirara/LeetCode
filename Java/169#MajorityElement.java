public class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 0;
        for (int n : nums) {
            if (count == 0) {
                major = n;
                count++;
            } else if (major == n) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}


public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}