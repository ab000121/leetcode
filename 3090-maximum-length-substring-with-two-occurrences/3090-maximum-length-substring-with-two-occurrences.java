class Solution {
    public int maximumLengthSubstring(String s) {
        int ans = 0;
        int left = 0;
        Map<Character,Integer> hm = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            hm.put(s.charAt(right) , hm.getOrDefault(s.charAt(right),0)+1);

            while(hm.get(s.charAt(right)) > 2){
                hm.put(s.charAt(left) , hm.get(s.charAt(left)) - 1 );

                left++;
            }

            ans = Math.max(ans , right-left+1);
        }

        return ans;
    }
}