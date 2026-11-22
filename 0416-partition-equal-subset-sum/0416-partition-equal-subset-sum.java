class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int i : nums){
            target += i;
        }

        if(target %2 != 0) return false;
        
        dp = new Boolean[nums.length][target/2+1];

        return helper(nums , 0 , target/2);
    }

    boolean helper(int[] nums, int index, int target){
        if(target == 0){
            return true;
        }

        if(index == nums.length){
            return false;
        }

        if(dp[index][target] != null){
            return dp[index][target];
        }

        boolean pick = false;
        if(nums[index] <= target){
            pick = helper(nums,index+1,target-nums[index]);
        }

        boolean skip =  helper(nums,index+1,target);

        return dp[index][target] = pick || skip;
    }
}