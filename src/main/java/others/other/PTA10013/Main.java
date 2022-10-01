package others.other.PTA10013;

import java.util.Scanner;

public class Main {
    int nCity;
    int nWay;
    int nCheck;
    boolean[][] haveWay;

    public static void main(String[] args) {
        new Main().main();
    }

    public void main() {
        var s = new Scanner(System.in);
        nCity = s.nextInt();//city < 1000
        nWay = s.nextInt();//highway
        nCheck = s.nextInt();//check city if lost
        haveWay = new boolean[nCity][nCity];
        for (int i = 0; i < nWay; ++i) {
            int a = s.nextInt() - 1;
            int b = s.nextInt() - 1;
            haveWay[a][b] = true;
            haveWay[b][a] = true;
        }
        for (int i = 0; i < nCheck; ++i) {
            int checkCity = s.nextInt() - 1;
            System.out.println(dfsTransVerse(checkCity));
        }
    }

    int dfsTransVerse(int destroy) {
        var visitCity = new boolean[nCity];
        int res = -1;
        for (int i = 0; i < nCity; ++i) {
            if (i == destroy) {
                continue;
            }
            if (visitCity[i]) {
                continue;
            }
            dfs(visitCity, i, destroy);
            ++res;
        }
        return res;
    }

    void dfs(boolean[] visitCity, int now, int destroy) {
        visitCity[now] = true;
        for (int i = 0; i < nCity; ++i) {
            if (visitCity[i]) {//来过
                continue;
            }
            if (!haveWay[now][i]) {//没路
                continue;
            }
            if (i == destroy) {//摧毁
                continue;
            }
            dfs(visitCity, i, destroy);
        }
    }

}
