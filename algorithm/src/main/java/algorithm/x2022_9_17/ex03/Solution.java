package algorithm.x2022_9_17.ex03;

class Solution {
    int[][] prefix;

    public static void main(String[] args) {
        System.out.println(1 << 30);
        var s = new Solution().smallestSubarrays(new int[]{1, 0, 2, 1, 3});
        System.out.println(s);
    }

    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        prefix = new int[n][31];
        for (int j = 0; j < 31; j++)
            prefix[0][j] = (nums[0] & (1 << j));
        for (int i = 1; i < n; i++) {
            int now = nums[i];
            for (int j = 0; j < 31; j++) {
                prefix[i][j] = prefix[i - 1][j] + (now & (1 << j));
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = sl(i, n - 1) - i + 1;
        }
        return ans;
    }

    int sl(int l, int r) {
        int target = getNum(l, r);
        System.out.println("l = " + l);
        System.out.println("r = " + r);
        for (int i = l; i < r; i++) {
            System.out.println("getNum(l, i)" + getNum(l, i));
        }

        while (l < r) {
            int mid = (l + r) / 2;
            if (getNum(l, mid) == target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println("l = " + l + "\n");
        return l;
    }

    int getNum(int l, int r) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            if (l == 0) {
                if (prefix[r][i] > 0)
                    ans |= (1 << i);
            } else if (prefix[r][i] - prefix[l - 1][i] > 0)
                ans |= (1 << i);
        }
        return ans;
    }


}