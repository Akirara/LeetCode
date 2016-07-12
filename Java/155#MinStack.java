public class MinStack {
    private Stack<Integer> sk;
    private Stack<Integer> minSk;

    /** initialize your data structure here. */
    public MinStack() {
        sk = new Stack();
        minSk = new Stack();
    }
    
    public void push(int x) {
        sk.push(x);
        if(minSk.size() == 0 || minSk.peek() >= x)
            minSk.push(x);
    }
    
    public void pop() {
        int top = sk.peek();
        sk.pop();
        if(minSk.peek() == top)
            minSk.pop();
    }
    
    public int top() {
        return sk.peek();
    }
    
    public int getMin() {
        return minSk.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


public class MinStack {
    List<Integer> sk;
    List<Integer> min;
    int countSk;
    int countMin;

    /** initialize your data structure here. */
    public MinStack() {
        sk = new ArrayList();
        min = new ArrayList();
        countSk = 0;
        countMin = 0;
    }
    
    public void push(int x) {
        sk.add(x);
        countSk++;
        if(countMin == 0 || x <= min.get(countMin - 1)) {
            min.add(x);
            countMin++;
        }
    }
    
    public void pop() {
        int top = sk.get(countSk - 1);
        sk.remove(countSk - 1);
        countSk--;
        if(min.get(countMin - 1) == top) {
            min.remove(countMin -1);
            countMin--;
        }
    }
    
    public int top() {
        return sk.get(countSk - 1);
    }
    
    public int getMin() {
        return min.get(countMin - 1);
    }   
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


public class MinStack {
    int[] sk;
    int[] min;
    int countSk;
    int countMin;

    /** initialize your data structure here. */
    public MinStack() {
        sk = new int[8000];
        min = new int[8000];
        countSk = 0;
        countMin = 0;
    }
    
    public void push(int x) {
        sk[countSk] = x;
        countSk++;
        if(countMin == 0 || x <= min[countMin - 1]) {
            min[countMin] = x;
            countMin++;
        }
    }
    
    public void pop() {
        if(min[countMin - 1] == sk[countSk - 1]) {
            countMin--;
        }
        countSk--;
    }
    
    public int top() {
        return sk[countSk - 1];
    }
    
    public int getMin() {
        return min[countMin - 1];
    }   
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */