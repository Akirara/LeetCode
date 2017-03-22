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


// quickly judge by using three boolean arrays
public class Solution {
    List<List<String>> res;
    
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<List<String>>();
        boolean[] leftSlant = new boolean[2 * n - 1];
        boolean[] rightSlant = new boolean[2 * n - 1];
        boolean[] row = new boolean[n];
        char[][] table = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = '.';
            }
        }
        
        recursion(table, 0, n, leftSlant, rightSlant, row);
        
        return res;
    }
    
    public void recursion(char[][] table, int k, int n, boolean[] leftSlant, boolean[] rightSlant, boolean[] row) {
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
            int leftIndex = 0;
            int rightIndex = 0;
            
            for (int i = 0; i < n; i++) {
                leftIndex = n + i - k - 1;
                rightIndex = i + k;
                
                if (leftSlant[leftIndex] || rightSlant[rightIndex] || row[i]) {
                    continue;
                } else {
                    leftSlant[leftIndex] = true;
                    rightSlant[rightIndex] = true;
                    row[i] = true;
                    table[i][k] = 'Q';
                    
                    recursion(table, k + 1, n, leftSlant, rightSlant, row);
                    
                    leftSlant[leftIndex] = false;
                    rightSlant[rightIndex] = false;
                    row[i] = false;
                    table[i][k] = '.';
                }
            }
        }
    }
}