/**/
package algorithm.JzOffer.Jz33;

/**/

class Solution {
    int[] nums;

    public static void main(String[] args) {
        new Solution().verifyPostorder(new int[]{4, 6, 7, 5});
    }

    public boolean verifyPostorder(int[] postorder) {
        nums = postorder;
        return dfs(0, nums.length - 1);
    }

    public boolean dfs(int l, int r) {
        if (l >= r) {
            return true;
        }
        int root = nums[r];
        int mid = 0;
        while (mid < r && nums[mid] < root) {
            mid++;
        }
        for (int i = mid; i < r; i++) {
            if (nums[i] < root)
                return false;
        }
        return dfs(l, mid - 1)
                && dfs(mid, r - 1);
    }
}