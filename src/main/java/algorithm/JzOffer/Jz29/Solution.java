/**/
package algorithm.JzOffer.Jz29;

/**/


class Solution {
    static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//右下左上
    int[] ans;
    int ansp = 0;
    boolean[][] visit;
    int[][] matrix;
    int m, n;
    boolean test;

    public static void main(String[] args) {
        var a = new Solution().spiralOrder(
                new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}
        );
        System.out.println(a);
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        m = matrix.length;
        n = matrix[0].length;
        visit = new boolean[m][n];
        this.matrix = matrix;
        ans = new int[m * n];
        dfs(0, 0, 0);
        return ans;
    }

    boolean dfs(int y, int x, int nowDir) {
        if (y < 0 || y >= m || x < 0 || x >= n || visit[y][x])
            return false;
        visit[y][x] = true;
        ans[ansp++] = matrix[y][x];
        if (matrix[y][x] == 13) {
            test = true;
        }
        for (int i = 0; i < 4; i++) {
            int t = (nowDir + i) % 4;
            if (dfs(y + dir[t][0], x + dir[t][1], t)) {
                return true;
            }
        }
        return true;
    }
}