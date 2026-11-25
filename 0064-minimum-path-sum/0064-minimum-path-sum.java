class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];

        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        return helper(grid,grid.length-1,grid[0].length-1);
    }

    int helper(int grid[][], int row , int col){
        if(row == 0 && col == 0)
            return grid[0][0];

        if(row <0 || col < 0)
            return Integer.MAX_VALUE;

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        return dp[row][col] = grid[row][col] + Math.min(helper(grid,row-1,col), helper(grid,row,col-1));
    }
}