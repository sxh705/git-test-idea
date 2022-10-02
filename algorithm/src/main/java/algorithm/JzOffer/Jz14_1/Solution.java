/**/
package algorithm.JzOffer.Jz14_1;

/**/
class Solution {
    static final int MOD = (int) 1e9 + 7;

    public int cuttingRope(int n) {
        if (n < 4) return n - 1;
        long ans = 1;
        while (n % 3 != 0 && n > 0) {
            n -= 2;
            ans *= 2;
        }
        return (int) (ans * qPow(n / 3) % MOD);
    }

    long qPow(long pow) {
        long base = 3, ans = 1;
        while (pow != 0) {
            if ((pow & 1) == 1) ans = ans * base % MOD;
            pow >>= 1;
            base = (base * base) % MOD;
        }
        return ans;
    }
}