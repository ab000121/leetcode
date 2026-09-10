class Solution {
    public int subarraySum(int[] nums, int k) {
       Map<Integer,Integer> hm = new HashMap<>();
       hm.put(0,1);

       int ans = 0;
       int prefixSum = 0;

       for(int num : nums){
        prefixSum += num;

        if(hm.containsKey(prefixSum - k)){
            ans = hm.get(prefixSum - k) + ans;
        }

        hm.put(prefixSum , hm.getOrDefault(prefixSum , 0) + 1);
       }

       return ans;
    }
}