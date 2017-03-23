public class Solution {
    int count = 0;
    
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        
        backtrack(visited, N, N);
        
        return count;
    }
    
    public void backtrack(boolean[] visited, int n, int k) {
        if (k == 0) {
            count++;
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % k == 0 || k % i == 0)) {
                visited[i] = true;
                backtrack(visited, n, k - 1);
                visited[i] = false;
            }
        }
    }
}