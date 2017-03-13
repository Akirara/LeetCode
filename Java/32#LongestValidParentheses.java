public class Solution {
    public int longestValidParentheses(String s) {
        LinkedList<Integer> sk = new LinkedList<Integer>();
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            if (sk.isEmpty()) {
                sk.addFirst(i);
            } else {
                if (s.charAt(i) == '(') {
                    sk.addFirst(i);
                } else {
                    if (s.charAt(sk.getFirst()) == '(') {
                        sk.removeFirst();
                    } else {
                        sk.addFirst(i);
                    }
                }
            }
        }
        
        if (sk.isEmpty()) {
            return len;
        }
        
        int max = 0;
        int a = len;
        int b;
        
        while(!sk.isEmpty()) {
            b = sk.removeFirst();
            max = Math.max(max, a - b - 1);
            a = b;
        }
        
        max = Math.max(max, a);
        
        return max;
    }
}