public class Solution {
    public int uniquePaths(int m, int n) {
        double sum = m + n - 2;
        double factorialN = 1;
        for(int i = 1; i < n; i++)
        	factorialN *= i;
        double factorialSum = 1;
        for(int i = m; i <= sum; i++)
        	factorialSum *= i;
        int ret = (int)(factorialSum / factorialN);
        return ret;
    }
}