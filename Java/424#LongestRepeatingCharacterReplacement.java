public class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0;
        int max = 0;
        int maxCount = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start - maxCount + 1 > k) {
                count[s.charAt(start++) - 'A']--;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}