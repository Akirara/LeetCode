public class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
        return sb.reverse().toString().toUpperCase();
    }
}


public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c == '-') {
                continue;
            }
            if (count == K) {
                sb.append("-");
                count = 0;
            }
            if (c >= 'a') {
                sb.append((char) (c - 32));
            } else {
                sb.append(c);
            }
            count++;
        }
        return sb.reverse().toString();
    }
}