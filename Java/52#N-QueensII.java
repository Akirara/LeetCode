public class Solution {
    int count = 0;
    
    public int totalNQueens(int n) {
        // int[] res = new int[]{1,0,0,2,10,4,40,92,352,724,14200,73712,365596,2279184};
        boolean[] col = new boolean[n];
        boolean[] lS = new boolean[2 * n - 1];
        boolean[] rS = new boolean[2 * n - 1];
        
        backtrack(0, n, col, lS, rS);
        
        return count;
    }
    
    public void backtrack(int r, int n, boolean[] col, boolean[] lS, boolean[] rS) {
        if (r == n) {
            count++;
            return;
        }
        
        int lI = 0;
        int rI = 0;
        
        for (int i = 0; i < n; i++) {
            lI = n + r - i - 1;
            rI = r + i;
            
            if (col[i] || lS[lI] || rS[rI]) {
                continue;
            } else {
                col[i] = true;
                lS[lI] = true;
                rS[rI] = true;
                
                backtrack(r + 1, n, col, lS, rS);
                
                col[i] = false;
                lS[lI] = false;
                rS[rI] = false;
            }
        }
    }
}