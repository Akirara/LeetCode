public class Solution {
    public String decodeString(String s) {
        Stack<String> ch = new Stack<>();
        Stack<Integer> k = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c <= '9' && c >= '0') {
                count = count * 10 + c - '0'; 
            } else if (c == ']') {
                tmp.delete(0, tmp.length());
                while(!ch.peek().equals("[")) {
                    tmp.insert(0, ch.pop());
                }
                count = k.pop();
                sb.delete(0, sb.length());
                for (int i = 0; i < count; i++) {
                    sb.append(tmp);
                }
                count = 0;
                ch.pop();
                ch.push(sb.toString());
            } else {
                if (c == '[') {
                    k.push(count);
                    count = 0;
                }
                ch.push(Character.toString(c));
            }
        }
        sb.delete(0, sb.length());
        while (!ch.empty()) {
            sb.insert(0, ch.pop());
        }
        return sb.toString();
    }
}


public class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}