public class Solution {
    List<List<String>> res;
    
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<List<String>>();
        char[][] table = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = '.';
            }
        }
        
        recursion(table, 0, n);
        
        return res;
    }
    
    public void recursion(char[][] table, int k, int n) {
        if (k == n) {
            List<String> solution = new ArrayList<String>();
            
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                
                for (int j = 0; j < n; j++) {
                    sb.append(table[i][j]);
                }
                
                solution.add(sb.toString());
            }
            
            res.add(solution);
        } else {
            for (int i = 0; i < n; i++) {
                if (isValid(table, i, k, n)) {
                    table[i][k] = 'Q';
                    recursion(table, k + 1, n);
                    table[i][k] = '.';
                }
            }
        }
    }
    
    public boolean isValid(char[][] table, int i, int j, int n) {
        int p = i;
        int q = j - 1;
        
        while (q >= 0) {
            if (table[p][q] == 'Q') {
                return false;
            }
            
            q--;
        }
        
        p = i - 1;
        q = j - 1;
        
        while (p >= 0 && q >= 0) {
            if (table[p][q] == 'Q') {
                return false;
            }
            
            p--;
            q--;
        }
        
        p = i + 1;
        q = j - 1;
        
        while (p < n && q >= 0) {
            if (table[p][q] == 'Q') {
                return false;
            }
            
            p++;
            q--;
        }
        
        return true;
    }
}