public class Solution {
    public int countSegments(String s) {
        int count = 0;
        int len = s.length();
        char[] ch = s.toCharArray();
        for (int i = 0; i < len; ) {
            while (ch[i] == ' ') {
                if (++i == len) {
                    return count;
                }
            }
            while (i < len && ch[i] != ' ') {
                i++;
            }
            count++;
        }
        return count;
    }
}