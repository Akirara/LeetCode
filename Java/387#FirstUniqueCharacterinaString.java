public class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int[] pos = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int val = s.charAt(i) - 'a';
            if (++count[val] == 1) {
                pos[val] = i;
            }
        }
        int ret = len;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 1 && pos[i] < ret) {
                ret = pos[i];
            }
        }
        return ret != len ? ret : -1;
    }
}