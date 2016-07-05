/*
*	general method for k times
*/
public class Solution {
    public int singleNumber(int[] nums) {
        int[] bit = new int[32];
        int res = 0;
        int n = nums.length;
        for(int i = 0; i < 32; i++) {
        	for(int j = 0; j < n; j++) {
        		bit[i] += (nums[j] >> i) & 1;
        	}
        	res |= (bit[i] % 3) << i;
        }
        return res;
    }
}

/*
*	unique method only for three times
*/
public class Solution {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
        	two |= one & nums[i];
        	one ^= nums[i];
        	three = one & two;
        	one &= ~three;
        	two &= ~three;
        }
        return one;
    }
}