class Solution {
    public String minWindow(String s, String t) {
        
        int freq[] = new int[256];

        for(char ch : t.toCharArray()) freq[ch]++;

        int l=0 , r=0;
        int count = 0;
        int req = t.length();
        int start = 0; 
        int minLen = Integer.MAX_VALUE;

        while(r < s.length()){
            if(freq[s.charAt(r)] > 0) count++;

            freq[s.charAt(r)]--;

            while(count == req){
                if(minLen > r - l + 1){
                    minLen = r - l + 1;
                    start = l;
                }

                freq[s.charAt(l)]++;
                if(freq[s.charAt(l)] > 0) count--;

                l++;
            }
            r++;
        }

        return (minLen == Integer.MAX_VALUE)? "" : s.substring(start , start + minLen);
    }
}