public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] product = new int[len];
        product[0] = 1;
        for (int i = 0; i < len - 1; i++) {
            product[i + 1] = product[i] * nums[i];
        }
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            product[i] *= right;
            right *= nums[i];
        }
        return product;
    }
}