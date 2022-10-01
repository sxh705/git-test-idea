class Solution {
    const int MAXP = 30;

public:
    vector<int> smallestSubarrays(vector<int>& nums) {
        int n = nums.size();
        vector<vector<int>> f(n, vector<int>(MAXP + 1));

        for (int i = MAXP; i >= 0; i--)
            if (nums[n - 1] >> i & 1)
                f[n - 1][i] = n - 1;//

        for (int i = n - 2; i >= 0; i--)
            for (int j = MAXP; j >= 0; j--) {
                f[i][j] = f[i + 1][j];
                if (nums[i] >> j & 1)
                    f[i][j] = i;
        }

        vector<int> ans(n);
        for (int i = 0; i < n; i++) {
            int mx = i;
            for (int j = 0; j <= MAXP; j++)
                mx = max(mx, f[i][j]);
            ans[i] = mx - i + 1;
        }
        return ans;
    }
};

作者：tsreaper
链接：https://leetcode.cn/problems/smallest-subarrays-with-maximum-bitwise-or/solution/by-tsreaper-icon/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。