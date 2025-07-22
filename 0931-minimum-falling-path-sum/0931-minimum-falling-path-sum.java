class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        Integer[][] dp = new Integer[n][n];

        int minPathSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minPathSum = Math.min(minPathSum, helper(0, col, matrix, dp));
        }

        return minPathSum;
    }

    private int helper(int row, int col, int[][] matrix, Integer[][] dp) {
        int n = matrix.length;
        if (col < 0 || col >= n) return Integer.MAX_VALUE;
        if (row == n - 1) return matrix[row][col];
        if (dp[row][col] != null) return dp[row][col];

        int down = helper(row + 1, col, matrix, dp);
        int leftDiag = helper(row + 1, col - 1, matrix, dp);
        int rightDiag = helper(row + 1, col + 1, matrix, dp);

        dp[row][col] = matrix[row][col] + Math.min(down, Math.min(leftDiag, rightDiag));
        return dp[row][col];
    }
}
