  public class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        boolean left = true;
        int num = n;
        while (num > 1) {
            if (left || num % 2 == 1) {
                head += step;
            }
            num /= 2;
            step *= 2;
            left = !left;
        }
        return head;
    }
}