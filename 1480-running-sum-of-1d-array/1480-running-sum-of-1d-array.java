class Solution {
    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            int temp = nums[i];
            nums[i] = temp + nums[i-1];
       }
       return nums;
    }
}