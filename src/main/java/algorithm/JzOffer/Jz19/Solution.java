/**/
package algorithm.JzOffer.Jz19;

/**/

import java.util.Scanner;

class Solution {
    String s, p;

    public static void main(String[] args) {
        var a = new Solution();
        var b = true;
        var sc = new Scanner(System.in);
        System.out.println("input Target, Pattern");
        b = a.isMatch(sc.next(), sc.next());
        System.out.println(b);
        main(null);
    }

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        return dfs(0, 0);
    }

    public boolean dfs(int ptrS, int ptrP) {
        if (ptrP == p.length())
            return ptrS == s.length();
        else if (ptrS == s.length()) {
            if (ptrP >= p.length() - 1)
                return false;
            if (p.charAt(ptrP + 1) != '*')
                return false;
            return dfs(ptrS, ptrP + 2);
        }
        //.* a*
        //. a
        char charS = s.charAt(ptrS);
        char charP = p.charAt(ptrP);
        if (charP == '.' || charP == charS) {
            if (ptrP >= p.length() - 1)
                return dfs(ptrS + 1, ptrP + 1);
            char charP1 = p.charAt(ptrP + 1);
            if (charP1 != '*')
                return dfs(ptrS + 1, ptrP + 1);
            return dfs(ptrS, ptrP + 2)
                    || dfs(ptrS + 1, ptrP);
        } else { //!a
            if (ptrP >= p.length() - 1) //!a/0
                return false;
            char np_1 = p.charAt(ptrP + 1);
            if (np_1 != '*') //!a x
                return false;
            return dfs(ptrS, ptrP + 2);
        }
    }
}