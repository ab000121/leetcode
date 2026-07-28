class Solution {
    public String smallestPalindrome(String s) {
        int [] freq = new int[26];

        for(char ch : s.toCharArray())
            freq[ch - 'a']++;

        StringBuilder middle = new StringBuilder();
        
        StringBuilder left = new StringBuilder();

        for(int i = 0; i < freq.length; i++){
            char ch = (char) (i + 'a');
            if(freq[i] % 2 != 0) middle.append(ch);
            int half = freq[i]/2;
            while(half > 0){
                left.append(ch);

                half--;
            }
        }

        StringBuilder right = new StringBuilder();
        for(int i = left.length()-1; i >= 0; i--){
            right.append(left.charAt(i));
        }

        if(middle.length() == 0){
            left.append(right);
        }
        else{
            left.append(middle);
            left.append(right);
        }

        return left.toString();

    }
}