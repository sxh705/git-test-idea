//
package algorithm.JzOffer.Jz05;

class Solution {
    public String replaceSpace(String s) {
        //sbuilder不能多线程
        var sb = new StringBuilder(s);
        int m = sb.length();
        int offSet = 0;
        for (int i = 0; i < m; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append("00");
            }
        }
        for (int cpa = m + offSet, i = m;
             i >= 0;
             i--) {
            char now = sb.charAt(i);
            if (now != ' ') {
                sb.setCharAt(cpa, now);
                cpa--;
            } else {
                sb.setCharAt(cpa - 2, '%');
                sb.setCharAt(cpa - 1, '2');
                sb.setCharAt(cpa, '0');
                cpa -= 3;
            }
        }
        return sb.toString();
    }
}