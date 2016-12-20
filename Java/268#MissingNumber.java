public class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        int i = 0;
        for (int n : nums) {
            xor = xor ^ i ^ n;
            i++;
        }
        return xor ^ i;
    }
}