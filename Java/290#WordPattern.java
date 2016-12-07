public class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, Integer> hs1 = new HashMap<>();
        HashMap<String, Integer> hs2 = new HashMap<>();
        String[] substring = str.split(" ");
        if (substring.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if ((int) hs1.getOrDefault(pattern.charAt(i), -1)
                != (int) hs2.getOrDefault(substring[i], -1)) {
                return false;
            } else {
                hs1.put(pattern.charAt(i), i);
                hs2.put(substring[i], i);
            }
        }
        return true;
    }
}