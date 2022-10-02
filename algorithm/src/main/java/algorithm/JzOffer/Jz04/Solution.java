package algorithm.JzOffer.Jz04;

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = n - 1, y = 0;
        while (x >= 0 && y >= 0 && x < n && y < m) {
            int now = matrix[y][x];
            if (now < target) {
                x--;
            } else if (now > target) {
                y++;
            } else {
                return true;
            }
        }
        return false;
    }
}