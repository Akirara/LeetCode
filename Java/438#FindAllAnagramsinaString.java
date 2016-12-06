public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        int lenS = s.length();
        int lenP = p.length();
        if (lenS < lenP) {
            return res;
        }
        int[] countP = new int[128];
        int distance = lenP;
        for (char c : p.toCharArray()) {
            countP[c]++;
        }
        char[] sArray = s.toCharArray();
        for (int i = 0; i < lenP - 1; i++) {
            if (countP[sArray[i]]-- > 0) {
                distance--;
            }
        }
        for (int i = 0, j = lenP - 1; j < lenS; i++, j++) {
            if (countP[sArray[j]]-- > 0) {
                distance--;
            }
            if (distance == 0) {
                res.add(i);
            }
            if (countP[sArray[i]]++ >= 0) {
                distance++;
            }
        }
        return res;
    }
}