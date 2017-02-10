public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        int len = timeSeries.length;
        if (len == 0) {
            return sum;
        }
        for (int i = 1; i < len; i++) {
            sum += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        return sum + duration;
    }
}