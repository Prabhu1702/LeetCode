class Solution {
    public int ways(int [][]dp, int i, int j){
        if(i==0 && j==0) return 1;

        if(i<0 || j<0 ) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int up= ways(dp,i-1,j);
        int left=ways(dp,i,j-1);

        dp[i][j]= up + left;

        return dp[i][j];

    }



    public int uniquePaths(int m, int n) {
        int [][] dp= new int[m][n];
            for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

       return  ways(dp,m-1,n-1);

       
    }
}