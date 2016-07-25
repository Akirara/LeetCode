class MyQueue {
    Stack<Integer> forward = new Stack();
    Stack<Integer> backward = new Stack();
    // Push element x to the back of queue.
    public void push(int x) {
        if(forward.empty())
            while(!backward.empty())
                forward.push(backward.pop());
        forward.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(backward.empty())
            while(!forward.empty())
                backward.push(forward.pop());
        backward.pop();
    }

    // Get the front element.
    public int peek() {
        if(backward.empty())
            while(!forward.empty())
                backward.push(forward.pop());
        return backward.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return forward.empty() && backward.empty() ? true : false;
    }
}


/**
*   improved method
*/
class MyQueue {
    Stack<Integer> forward = new Stack();
    Stack<Integer> backward = new Stack();
    // Push element x to the back of queue.
    public void push(int x) {
        forward.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!backward.empty())
            backward.pop();
        else {
            while(!forward.empty())
                backward.push(forward.pop());
            backward.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if(!backward.empty())
            return backward.peek();
        else {
            while(!forward.empty())
                backward.push(forward.pop());
            return backward.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return forward.empty() && backward.empty() ? true : false;
    }
}