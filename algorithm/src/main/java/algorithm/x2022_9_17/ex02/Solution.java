package algorithm.x2022_9_17.ex02;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        var P = new ArrayList<Integer>();
        for (var x : players) {
            P.add(x);
        }
        Collections.sort(P);
        var T = new ArrayList<Integer>();
        for (var x : trainers) {
            T.add(x);
        }
        Collections.sort(T);
        int Pi = 0, Ti = 0;
        int ans = 0;
        for (; Pi < P.size(); Pi++) {
            var now = P.get(Pi);
            for (; Ti < T.size(); Ti++) {
                if (now > T.get(Ti)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}