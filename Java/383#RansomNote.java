public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letter = new int[128];
        for (char c : magazine.toCharArray()) {
            letter[c]++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--letter[c] < 0) {
                return false;
            }
        }
        return true;
    }
}