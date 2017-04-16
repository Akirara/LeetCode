public class Solution {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int len = ch.length;
        
        int start = 0;
        int end = 0;
        StringBuilder reverse = new StringBuilder();
        
        while (start < len) {
            while (ch[start] == ' ') {
                reverse.append(' ');
                start++;
            }
            end = start;
            while (end < len && ch[end] != ' ') {
                end++;
            }
            for (int i = end - 1; i >= start; i--) {
                reverse.append(ch[i]);
            }
            start = end;
        }
        
        return reverse.toString();
    }
}

public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s");
        StringBuilder reverse = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            StringBuilder tmp = new StringBuilder(words[i]);
            if (i > 0) {
                reverse.append(" ");
            }
            reverse.append(tmp.reverse());
        }
        
        return reverse.toString();
    }
}