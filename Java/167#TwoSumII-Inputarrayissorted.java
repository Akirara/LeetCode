// two pointers
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int high = numbers.length - 1;
        if (high < 1) {
            return null;
        }
        int low = 0;
        int sum = 0;
        int[] ret = new int[2];
        
        while (low < high) {
            sum = numbers[low] + numbers[high];
            if (sum == target) {
                ret[0] = low + 1;
                ret[1] = high + 1;
                break;
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        
        return ret;
    }
}