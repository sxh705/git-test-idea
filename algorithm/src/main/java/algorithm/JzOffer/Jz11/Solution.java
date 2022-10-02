/**/
package algorithm.JzOffer.Jz11;

/**/
class Solution {
    int[] nums;

    public static void main(String[] args) {
        var a = new int[]{3, 1, 3};
        var b = new Solution();
        var c = b.minArray(a);
        System.out.println(c);
    }

    public int minArray(int[] numbers) {
        nums = numbers;
        return binarySearch(0, nums.length - 1);
    }

    public int binarySearch(int l, int r) {
        if (l >= r) //非法的
            return nums[l];
        if (nums[l] < nums[r]) //顺序的
            return nums[l];
        int mid = (l + r) / 2;
        if (nums[l] == nums[r]
                && nums[l] == nums[mid]) { //相等的
            for (int i = l + 1; i < r; i++)
                if (nums[i] < nums[l])
                    return nums[i]; //第一个小于l的
            return nums[l]; //完全一样
        }
        if (nums[mid] >= nums[l]) { //mid在左区间
            return binarySearch(mid + 1, r);
        } else if (nums[mid] <= nums[r]) { //mid在右区间
            return binarySearch(l, mid);
        }
        return -1;
    }

}