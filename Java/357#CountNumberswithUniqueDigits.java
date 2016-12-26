public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int count = 9;
        int sum = 10;
        for (int i = 1; i < n && i < 11; i++) {
            count *= 10 - i;
            sum += count;
        }
        return sum;
    }
}