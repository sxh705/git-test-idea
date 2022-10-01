package algorithm.JzOffer.Jz16_1;

/**
 * package JzOffer.Jz17;
 * <p>
 * /
 **/
class Solution {
    public double myPow(double base, int n) {
        if (n > 0) {
            return myPow(base, (long) n);
        } else if (n < 0) {
            return myPow(1.0 / base, -(long) n);
        } else if (n == 0) {
            return 1.0;
        }
        return -1;
    }

    public double myPow(double base, long n) {
        double ans = 1.0;
        while (n != 0) {
            if ((n & 1) == 1)
                ans *= base;
            base *= base;
            n >>= 1;
        }
        return ans;
    }
}