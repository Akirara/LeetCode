public class Solution {
    public int[] plusOne(int[] digits) {
 		int len = digits.length;
 		for(int i = len - 1; i >= 0; i--) {
 			digits[i] += 1;
 			if(digits[i] == 10) {
 				digits[i] = 0;
 			}
 			else {
 				return digits;
 			}
 		}
 		int[] ret = new int[len + 1];
 		ret[0] = 1;
 		for(int i = 1; i <= len; i++) {
 			ret[i] = digits[i - 1];
 		}
 		return ret;
    }
}