class Solution {
    public int minimumPushes(String word) {
        
        int freq[] = new int[26];
        int n = word.length();
        int minPress = 0;

        for(int i = 0; i < n; i++){
           freq[word.charAt(i) - 'a']++;  
        }

        Arrays.sort(freq);
        int keyCount = 0;
        for(int i = 25; i >= 0; i--){
            if(freq[i] == 0) continue;
            
            int press = keyCount / 8 + 1;

            minPress += press * freq[i];
            
            keyCount++;

        }

        return minPress;
    }
}