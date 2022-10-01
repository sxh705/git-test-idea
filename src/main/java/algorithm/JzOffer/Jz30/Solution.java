/**/
package algorithm.JzOffer.Jz30;

/**/

import java.util.Stack;

class MinStack {
    Stack<Integer> stack, mS;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        mS = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (mS.empty() || x < mS.peek()) {
            mS.push(x);
        } else {
            mS.push(mS.peek());
        }
    }

    public void pop() {
        stack.pop();
        mS.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return mS.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */