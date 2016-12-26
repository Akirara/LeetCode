public class Solution {
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        int pre = 0;
        for (int i = 0; i < lenS; i++) {
            pre = t.indexOf(s.charAt(i), pre);
            if (pre == -1) {
                return false;
            }
            pre++;
        }
        return true;
    }
}