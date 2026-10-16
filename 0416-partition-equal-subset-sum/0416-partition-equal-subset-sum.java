class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for(int n : nums){
            sum += n;
        }
        if(sum % 2 != 0) return false;

        Boolean[][] memo = new Boolean[nums.length][sum];
        return helper(nums,sum/2,0,memo);
    }

    boolean helper(int[] nums, int sum, int n, Boolean[][]memo){
        if(sum == 0){
            return true;
        }
        if(n == nums.length) return false;

        if(memo[n][sum] != null) return memo[n][sum];

        boolean take = false;
        if(nums[n] <= sum){
            take = helper(nums,sum-nums[n],n+1,memo);
        }
        
        boolean skip = helper(nums,sum,n+1,memo);
        
        return memo[n][sum] = take || skip;
    }
}