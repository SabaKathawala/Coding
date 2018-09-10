package adobe;

//Min Stack
// for each node keep track of Min till that Node. :) Loved it
import java.util.LinkedList;

public class MinStack {

    private class Node {
        Integer val;
        Integer prevMin;
    }
    private LinkedList<Node> stack = new LinkedList<Node>();
    public void push(int x) {
        Node n = new Node();
        n.val = x;
        n.prevMin = stack.peek() != null ? Math.min(stack.peek().prevMin, n.val) : n.val;
        stack.push(n);
    }

    public void pop() {
        if (stack.peek() != null) {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek() == null ? -1 : stack.peek().val;
    }

    public int getMin() {
        return stack.peek() == null ? -1 : stack.peek().prevMin;
    }
}
