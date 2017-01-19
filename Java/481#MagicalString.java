public class Solution {
    public int magicalString(int n) {
        if (n < 1) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }
        int[] s = new int[n + 1];
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;
        int head = 2;
        int tail = 3;
        int num = 1;
        int result = 1;
        while (tail < n) {
            for (int i = 0; i < s[head]; i++) {
                s[tail] = num;
                if (num == 1 && tail < n) {
                    result++;
                }
                tail++;
            }
            num ^= 3;
            head++;
        }
        return result;
    }
}