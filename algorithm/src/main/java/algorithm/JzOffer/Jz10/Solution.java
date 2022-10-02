/**/
package algorithm.JzOffer.Jz10;

/**/
class Solution {
    public int numWays(int n) {
        return fib(n + 1);
    }

    public int fib(int n) {
        final int MOD = (int) 1e9 + 7;
        var dp = new int[]{0, 1};
        for (int i = 2; i <= n; i++)
            dp[i % 2] = (dp[0] + dp[1]) % MOD;
        return dp[n % 2];

    }
}