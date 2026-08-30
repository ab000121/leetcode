class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int maxElIdx = 0;
        int minElIdx = 0;

        for(int i=0 ;i<n ;i++){
            if(nums[i] > nums[maxElIdx] ){
                maxElIdx = i;
            }
            if(nums[i] < nums[minElIdx]){
                minElIdx = i;
            }
        }

        int left = Math.min(maxElIdx,minElIdx);
        int right = Math.max(maxElIdx,minElIdx);

        return Math.min(Math.min(left+1 + n-right,right+1),n-left);
    } 
}