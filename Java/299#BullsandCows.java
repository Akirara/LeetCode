public class Solution {
    public String getHint(String secret, String guess) {
        char[] s1 = secret.toCharArray();
        char[] s2 = guess.toCharArray();
        int[] count = new int[60];
        int len = s1.length;
        int numA = 0;
        int numB = 0;
        for (int i = 0; i < len; i++) {
            if (s1[i] == s2[i]) {
                numA++;
            } else {
                if (count[s1[i]]++ < 0) {
                    numB++;
                }
                if (count[s2[i]]-- > 0) {
                    numB++;
                }
            }
        }
        return new String(numA + "A" + numB + "B");
    }
}