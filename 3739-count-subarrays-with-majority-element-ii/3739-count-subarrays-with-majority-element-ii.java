class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        long countAtSum[] = new long[(2*n)+2];
        long cumulativeSum[] = new long[(2*n)+2];

        int idx = n+1; //assuming the zero index
        countAtSum[idx] = 1;
        cumulativeSum[idx] = 1;

        long ans = 0;

        for(int i : nums){

            if(i == target) idx++;
            else idx--;

            countAtSum[idx]++;

            ans += cumulativeSum[idx-1];

            cumulativeSum[idx] = cumulativeSum[idx-1] + countAtSum[idx];

        }

        return ans;
    }
}