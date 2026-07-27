class Solution {
    public int uniqueXorTriplets(int[] nums) {
        

        // brute force solution
        int max = nums[0];
        for(int num : nums) max = Math.max(max , num);
        
        int mx = (max << 1);
        boolean[] pair = new boolean[mx];
        for(int i : nums){
            for(int j : nums){
                pair[i ^ j] = true;
            }
        }

        boolean[] res = new boolean[mx];
        for(int i = 0; i < mx; i++){
            if(pair[i]){
                for(int num : nums){
                    res[i ^ num] = true;
                }
            }
        }
        int ans = 0;
        for(boolean bool : res){
            if(bool) ans++;
        }

        return ans;
    }
}