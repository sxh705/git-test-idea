/**/
package algorithm.JzOffer.Jz33_Stack;

/**/

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public boolean verifyPostorder(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int rootVal = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > rootVal)
                return false;
            while (!stack.isEmpty() && nums[i] < stack.peek())
                rootVal = stack.pop();
            stack.push(nums[i]);
        }
        return true;
    }
}