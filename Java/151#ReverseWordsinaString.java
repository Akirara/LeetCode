public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i > 0; --i) {
        	sb.append(words[i]);
        	sb.append(" ");
        }
        if(words.length > 0)
        	sb.append(words[0]);
        return sb.toString();
    }
}