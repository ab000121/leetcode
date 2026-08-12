class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        
        Map<Integer,Integer> hm = new HashMap<>();

        for(int right = 0; right < nums.length; right++){
            hm.put(nums[right] , hm.getOrDefault(nums[right],0)+1);

            while(hm.get(nums[right]) > k){
                hm.put(nums[left] , hm.get(nums[left]) - 1 );

                left++;
            }

            ans = Math.max(ans , right-left+1);
        }

        return ans;
        
    }
}