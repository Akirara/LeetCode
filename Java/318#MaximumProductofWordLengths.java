public class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] bitmap = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (char c : words[i].toCharArray()) {
                bitmap[i] |= 1 << (c - 'a');
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((bitmap[i] & bitmap[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}