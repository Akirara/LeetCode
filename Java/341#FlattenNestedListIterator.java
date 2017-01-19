/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> sk;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        sk = new Stack<NestedInteger>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            sk.push(nestedList.get(i));   
        }
    }

    @Override
    public Integer next() {
        return sk.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!sk.isEmpty()) {
            NestedInteger top = sk.peek();
            if (top.isInteger()) {
                return true;
            }
            sk.pop();
            for (int i = top.getList().size() - 1; i >= 0; i--) {
                sk.push(top.getList().get(i));
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */


 public class NestedIterator implements Iterator<Integer> {
    NestedInteger nextInt;
    Stack<Iterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<Iterator<NestedInteger>>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return nextInt != null ? nextInt.getInteger() : null;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) stack.pop();
            else if ((nextInt = stack.peek().next()).isInteger()) return true;
            else stack.push(nextInt.getList().iterator());
        }
        return false;
    }
}