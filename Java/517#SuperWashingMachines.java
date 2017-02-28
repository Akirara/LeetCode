public class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for (int n : machines) {
            sum += n;
        }
        if (sum % machines.length != 0) {
            return -1;
        }
        int avg = sum / machines.length;
        int max = 0;
        int count = 0;
        for (int n : machines) {
            count += n - avg;
            max = Math.max(Math.max(max, Math.abs(count)), n - avg);
        }
        return max;
    }
}