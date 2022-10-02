/**/
package algorithm.JzOffer.Jz21;
/**/

class Solution {
    public int[] exchange(int[] nums) {
        //奇左偶右
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] % 2 != 0) {
                l++;
            } else if (nums[r] % 2 == 0) {
                r--;
            } else {
                var t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
                l++;
                r--;
            }
        }
        return nums;
    }
}