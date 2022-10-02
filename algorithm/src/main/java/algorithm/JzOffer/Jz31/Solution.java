/**/
package algorithm.JzOffer.Jz31;

/**/

import java.util.Stack;

/**
 * package JzOffer.Jz31;
 * <p>
 * /
 **/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int i = 0;
        for (int k : popped) {
            while (s.empty() || s.peek() != k) {
                if (i >= pushed.length)
                    return false;
                s.push(pushed[i++]);
            }
            s.pop();
        }
        return true;

    }
}
