class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;

        for (int left = 0; left < n; left++) {

            int count = 0;

            for (int right = left; right < n; right++) {

                if (nums[right] == target) {
                    count++;
                }

                int length = right - left + 1;

                if (2 * count > length) {
                    ans++;
                }
            }
        }
        return ans;
    }
}