/**/
package algorithm.JzOffer.Jz12;

/**/
class Solution {
    final int[][] dir =
            new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    char[][] board;
    String word;
    boolean[][] visited;

    public static void main(String[] args) {
        var a1 = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        var a2 = "ABCCED";
        var b = new Solution();
        var c = b.exist(a1, a2);
        System.out.println(c);
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        this.board = board;
        this.word = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited = new boolean[board.length][board[0].length];
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(int y, int x, int id) {
        if (x < 0 || y < 0
                || x >= board[0].length || y >= board.length) {
            return false;
        }
        if (visited[y][x]) {
            return false;
        }
        if (board[y][x] != word.charAt(id)) {
            return false;
        }
        if (id == word.length() - 1) {
            return true;
        }
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            if (dfs(y + dir[i][0], x + dir[i][1], id + 1)) {
                return true;
            }
        }
        visited[y][x] = false;
        return false;
    }


}