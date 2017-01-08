public class Solution {
    public int lengthLongestPath(String input) {
        String[] dir = input.split("\n");
        int[] preLen = new int[dir.length + 1];
        int maxLen = 0;
        int curLen = 0;
        int lev = 0;
        for (String s : dir) {
            lev = s.lastIndexOf("\t") + 1;
            curLen = preLen[lev] + s.length() - lev + 1;
            preLen[lev + 1] = curLen;
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, curLen - 1);
            }
        }
        return maxLen;
    }
}