class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean hasNoZero = false;

        for(int num : nums){
            xor ^= num;

            if(num != 0) hasNoZero = true;
        }

        if(xor != 0) return nums.length;
        if(hasNoZero) return nums.length -1;

        return 0;
    }
}