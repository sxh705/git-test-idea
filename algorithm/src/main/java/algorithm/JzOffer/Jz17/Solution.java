/**/

package algorithm.JzOffer.Jz17;

/**/

class Solution {
    public int[] printNumbers(int n) {
        int[] ans;
        int maxn = myPow(n);
        ans = new int[maxn];
        for (int i = 0; i < n; i++) {
            ans[i] = i;
        }
        return ans;
    }

    public int myPow(int n) {
        int ans = 1, base = 10;
        while (n != 0) {
            if ((n & 1) == 1) ans *= base;
            base *= base;
            n >>= 1;
        }
        return ans;
    }
}