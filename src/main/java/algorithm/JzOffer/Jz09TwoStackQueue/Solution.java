/**/
package algorithm.JzOffer.Jz09TwoStackQueue;

import java.util.Stack;

/**/
class CQueue {
    Stack<Integer> a, b;

    public CQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void appendTail(int value) {
        b.push(value);
    }

    public int deleteHead() {
        if (a.empty()) {
            if (b.empty()) {
                return -1;
            } else {
                do {
                    a.push(b.pop());
                } while (!b.empty());
            }
        }
        return a.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */