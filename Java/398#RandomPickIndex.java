public class Solution {
    int[] array;
    Random rand;
    public Solution(int[] nums) {
        array = nums;
        rand = new Random();
    }

    public int pick(int target) {
        int count = 0;
        int ret = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target && rand.nextInt(++count) == 0) {
                ret = i;
            }
        }
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */