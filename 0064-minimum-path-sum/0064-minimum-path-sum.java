class Solution {
    private int path(int [][]dp, int i , int j , int[] []grid){

       if(i < 0 || j < 0) return Integer.MAX_VALUE;
        if(i == 0 && j == 0) return grid[0][0];
        if(dp[i][j]!= -1) return dp[i][j];
        

        int up=  path(dp,i-1,j, grid );
        int left= path(dp,i,j-1, grid ); 

        dp[i][j] = grid[i][j] + Math.min(up, left);
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
          int [][] dp= new int[m][n];
            for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

       return  path(dp,m-1,n-1,grid);

    }
}