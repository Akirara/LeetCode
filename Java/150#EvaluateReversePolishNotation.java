public class Solution {
    public int evalRPN(String[] tokens) {
    	int len = tokens.length;
    	if(len == 0)
    		return 0;
    	Stack<Integer> sk = new Stack();
    	for(int i = 0; i < len; ++i) {
    		switch(tokens[i]) {
    			case "+":
    				sk.push(sk.pop() + sk.pop());
    				break;
    			case "-":
    				sk.push(-sk.pop() + sk.pop());
    				break;
    			case "*":
    				sk.push(sk.pop() * sk.pop());
    				break;
    			case "/":
    				int a = sk.pop();
    				sk.push(sk.pop() / a);
    				break; 
    			default:
    				sk.push(Integer.parseInt(tokens[i]));
    				break;
    		}
    	}
    	return sk.peek();
    }
}