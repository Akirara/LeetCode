public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0)
            return 0;
        
        int[] ways = new int[len + 1];
        ways[0] = 1;
        if(s.charAt(0) == '0')
            return 0;
        if(len == 1)
            return 1;
        else
            ways[1] = 1;

        for(int i = 1; i < len; i++) {
            if(s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7')) {
                if(s.charAt(i) == '0')
                    ways[i + 1] = ways[i - 1];
                else
                    ways[i + 1] = ways[i] + ways[i - 1];
            }
            else if(s.charAt(i) == '0')
                return 0;
            else
                ways[i + 1] = ways[i];
        }
        return ways[len];
    }
}