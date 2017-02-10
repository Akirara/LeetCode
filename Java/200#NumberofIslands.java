public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = 0;
        if (m > 0) {
            n = grid[0].length;
        } else {
            return count;
        }
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, m, n, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, boolean[][] visited, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        dfs(grid, visited, m, n, i, j - 1);
        dfs(grid, visited, m, n, i, j + 1);
        dfs(grid, visited, m, n, i - 1, j);
        dfs(grid, visited, m, n, i + 1, j);
    }
}


//Union Find Solution
public class Solution {
    class UF {
        public int count = 0;
        public int[] id;
        
        public UF(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                    }
                }
            }
            int p = m * n;
            id = new int[p];
            for (int i = 0; i < p; i++) {
                id[i] = i;
            }
        }
        
        public int find(int p) {
            while (p != id[p]) {
                p = id[p];
            }
            return p;
        }
        
        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot != qRoot) {
                id[pRoot] = qRoot;
                 count--;
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        UF uf = new UF(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                int p = i * n + j;
                if (i > 0 && grid[i - 1][j] == '1') {
                    uf.union(p, p - n);
                }
                if (j > 0 && grid[i][j - 1] == '1') {
                    uf.union(p, p - 1);
                }
            }
        }
        return uf.count;
    }
}