public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> l = new ArrayList<>();
        backtrack(res, l, s, 0);
        
        return res;
    }
    
    public void backtrack(List<List<String>> res, List<String> l, String s, int pos) {
        if (pos >= s.length()) {
            if (l.size() > 0) {
                List<String> tmp = new ArrayList<>();
                tmp.addAll(l);
                res.add(tmp);
            }
            return;
        }
        
        for (int i = pos; i < s.length(); i++) {
            if (isPalindrome(s, pos, i)) {
                l.add(s.substring(pos, i + 1));
                backtrack(res, l, s, i + 1);
                l.remove(l.size() - 1);
            }
        }
        
    }
    
    public boolean isPalindrome(String s, int b, int e) {
        while (b < e) {
            if (s.charAt(b) != s.charAt(e)) {
                return false;
            }
            b++;
            e--;
        }
        return true;
    } 
}