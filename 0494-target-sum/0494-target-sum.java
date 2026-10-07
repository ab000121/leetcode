class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums,target,0,0,0);
    }

    public int helper(int[] nums, int target, int sum , int idx, int ways){
        if(idx == nums.length && sum == target){
            ways += 1;
            return ways;
        }


        if(idx == nums.length && sum != target) return 0;


        int pos = helper(nums , target , sum + nums[idx], idx+1, ways);
        int neg = helper(nums , target , sum - nums[idx], idx +1, ways);

        return pos + neg;
    }
}