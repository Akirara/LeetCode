public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        int lg = g.length;
        int ls = s.length;
        if (lg == 0 || ls == 0) {
            return result;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; i < lg && j < ls; ++j) {
            if (g[i] <= s[j]) {
                ++result;
                ++i;
            }
        }
        return result;
    }
}