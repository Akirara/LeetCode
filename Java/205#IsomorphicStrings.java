public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] flagS = new int[128];
        int[] flagT = new int[128];
        for (int i = 0; i < s.length(); i++) {
            if (flagS[s.charAt(i)] != flagT[t.charAt(i)]) {
                return false;
            } else {
                flagS[s.charAt(i)] = i + 1;
                flagT[t.charAt(i)] = i + 1;
            }
        }
        return true;
    }
}