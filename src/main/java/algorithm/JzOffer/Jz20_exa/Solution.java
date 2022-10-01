/**/
package algorithm.JzOffer.Jz20_exa;
/**/

class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();
        boolean numFlag = false;
        boolean eFlag = false;
        boolean dotFlag = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                numFlag = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                if (!numFlag || eFlag)
                    return false;
                eFlag = true;
                numFlag = false;
            } else if (chars[i] == '.') {
                if (dotFlag || eFlag)
                    return false;
                dotFlag = true;
            } else if (chars[i] == '+' || chars[i] == '-') {
                if (i > 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E')
                    return false;
            } else {
                return false;
            }
        }
        return numFlag;
    }
}