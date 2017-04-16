public class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNumber = new int[n];
        uglyNumber[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        int v2 = 2, v3 = 3, v5 = 5;
        
        for (int i = 1; i < n; i++) {
            if (v2 == uglyNumber[i - 1]) {
                v2 = 2 * uglyNumber[++p2];
            }
            if (v3 == uglyNumber[i - 1]) {
                v3 = 3 * uglyNumber[++p3];
            }
            if (v5 == uglyNumber[i - 1]){
                v5 = 5 * uglyNumber[++p5];
            }
            uglyNumber[i] = Math.min(Math.min(v2, v3), v5);
        }
        
        return uglyNumber[n - 1];
    }
}