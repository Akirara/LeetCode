public class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int len = s.length() - 1;
        int i = 0;
        int j = Math.min(k - 1, len);
        
        while (i <= len) {
            int low = i;
            int high = j;
            while (low < high) {
                char tmp = ch[low];
                ch[low] = ch[high];
                ch[high] = tmp;
                low++;
                high--;
            }
            
            i += 2 * k;
            j = Math.min(i + k - 1, len);
        }
        
        return new String(ch);
    }
}