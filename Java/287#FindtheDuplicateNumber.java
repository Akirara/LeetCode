public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = nums[0];
        int fast = nums[slow];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}


public class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int n : nums) {
                if (n <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}