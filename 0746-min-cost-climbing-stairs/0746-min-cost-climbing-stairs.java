class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(helper(cost, 0) , helper(cost, 1));
    }

    public int helper(int[] cost, int index){
        if(index >= cost.length){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        return dp[index] = cost[index] + Math.min(helper(cost,index+1) , helper(cost,index+2));

    }
}