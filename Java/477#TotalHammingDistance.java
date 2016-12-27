public class Solution {
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        int bitCount = 0;
        int len = nums.length;
        for (int i = 0; i < 32; i++) {
            bitCount = 0;
            for (int n : nums) {
                bitCount += (n >> i) & 1;
            }
            sum += bitCount * (len - bitCount);
        }
        return sum;
    }
}