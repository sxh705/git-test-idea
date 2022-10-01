package algorithm.x2022_9_17.ex01;

class Solution {
    static final int[] dates = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        var s = new Solution().countDaysTogether("08-15", "08-18", "08-16", "08-19");
        System.out.println(s);

    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aA = toDays(arriveAlice);
        int lA = toDays(leaveAlice);
        int aB = toDays(arriveBob);
        int lB = toDays(leaveBob);
        if (lA < aB || lB < aA) {
            return 0;
        } else {
            if (aA > aB) {
                return lB - aA + 1;
            } else {
                return lA - aB + 1;
            }
        }
    }

    int toDays(String arrive) {
        var s = arrive.split("-");
        int month = Integer.parseInt(s[0]);
        int day = Integer.parseInt(s[1]);
        for (int i = 1; i < month; i++) {
            day += dates[i];
        }
        return day;
    }
}