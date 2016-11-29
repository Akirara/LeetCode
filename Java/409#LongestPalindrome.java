public class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        boolean hasSingle = false;
        int sum = 0;
        for (int n : count) {
            if (n % 2 == 0) {
                sum += n;
            } else {
                sum += n - 1;
                hasSingle = true;
            }
        }
        if (hasSingle) {
            sum++;
        }
        return sum;
    }
}