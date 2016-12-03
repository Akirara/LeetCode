public class Solution {
    public int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }
        return (int)((Math.sqrt(n * 8.0 + 1) - 1) / 2);
    }
}