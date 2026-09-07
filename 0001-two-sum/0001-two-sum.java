class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hm = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int rem = target - nums[i];

            if(hm.containsKey(nums[i])){
                return new int[]{i , hm.get(nums[i])};
                
            }
            else{
                hm.put(rem , i);
            }

            
        }

        return new int[]{-1,-1};
    }
}
