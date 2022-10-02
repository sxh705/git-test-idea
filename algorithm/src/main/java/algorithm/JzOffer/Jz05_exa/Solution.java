//
package algorithm.JzOffer.Jz05_exa;

class Solution {
    public String replaceSpace(String s) {
        var sb = new StringBuilder();//sbuilder不能多线程
        int m = sb.length();
        for (int i = 0; i < m; i++) {
            char now = s.charAt(i);
            if (now != ' ') {
                sb.append(s.charAt(i));
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}