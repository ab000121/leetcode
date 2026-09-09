class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int ans = 0;
        int right = 0;

        while(right < s.length()){
            int i = left;

            while(i < right){
                if(s.charAt(i) == s.charAt(right)){
                    left = i + 1;
                   
                }
                i++;
            }

            ans = Math.max(ans , right - left + 1);
            right++;
        }
        return ans;

    }
}