/**/
package algorithm.JzOffer.Jz20;
/**/


class Solution {
    char[] a;
    int i = 0;
    int len;

    public static void main(String[] args) {
        var a = new Solution().isNumber("3.5e+3.5e+3.5");
        System.out.println(a);
    }

    public boolean isNumber(String s) {
        s += '@';
        a = s.toCharArray();
        while (a[i] == ' ')
            i++;
        if (!checkRealNumber())
            return false;
        if (a[i] == 'E' || a[i] == 'e') {
            i++;
            if (a[i] == '+' || a[i] == '-')
                i++;
            if (!checkUnsignedInt())
                return false;
        }
        while (a[i] == ' ')
            i++;
        return a[i] == '@';
    }

    public boolean checkRealNumber() {
        if (a[i] == '+' || a[i] == '-')
            i++;
        if (checkUnsignedInt()) {
            if (a[i] == '.') {
                i++;
                checkUnsignedInt();
                return true;
            }
            return true;
        } else if (a[i] == '.') {
            i++;
            return checkUnsignedInt();
        }
        return false;
    }

    public boolean checkUnsignedInt() {
        if ('0' <= a[i] && a[i] <= '9') {
            i++;
            while ('0' <= a[i] && a[i] <= '9') {
                i++;
            }
            return true;
        } else {
            return false;
        }
    }
}