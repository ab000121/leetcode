class Solution {
    int [][]dp;

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        

        return helper(text1, text2 , 0 , 0);
    }

    public int helper(String text1, String text2, int idx1, int idx2) {
        if (idx1 == text1.length() || idx2 == text2.length()) {
            return 0;
        }

        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }

        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            dp[idx1][idx2] = 1 + helper(text1, text2, idx1 + 1, idx2 + 1);
        }

        else{
            dp[idx1][idx2] = Math.max(helper(text1, text2, idx1 + 1, idx2) , helper(text1, text2, idx1, idx2 + 1));
        }
        return dp[idx1][idx2]; 
    }
}