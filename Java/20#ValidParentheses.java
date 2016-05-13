public class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        char[] stack = new char[len + 1];

        stack[0] = '$';
        int index = 1;

        for(int i = 0; i < len; i++) {
        	char c = s.charAt(i);

        	switch(c) {
        		case '(':
        		case '[':
        		case '{':
        			stack[index] = c;
        			index++;
        			break;
        		case ')':
					if(stack[index - 1] == '(') {
						index--;
					}
					else {
						return false;
					}
					break;
				case ']':
					if(stack[index - 1] == '[') {
						index--;
					}
					else {
						return false;
					}
					break;
				case '}':
					if(stack[index - 1] == '{') {
						index--;
					}
					else {
						return false;
					}
					break;
				default:	break;
        	}

        }

        if(index == 1)
        	return true;

        return false;
    }
}