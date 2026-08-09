class Solution {
    int [][] dp;
    int [] suffix;
    int n;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new int[n][n+1];
        suffix = new int [n+1];
        
        for(int i = n-1; i >= 0; i--){
            suffix[i] = suffix[i+1] + piles[i];
        }

        return solve(0 , 1 , piles);

    }


    public int solve(int i , int M , int[] piles ){
        if(i >= n) return 0;  // no piles left

        if(2 * M >= n - i) return suffix[i];  // can take all remaining piles

        if(dp[i][M] != 0) return dp[i][M];  // already solved

        int best = 0;

        //try taking X piles
        for(int X = 1; X <= 2*M; X++){
            //stones opponent can get afterwards
            int opp = solve(X+i , Math.max(M,X) , piles);

            //current player total 
            int current = suffix[i] - opp;

            best = Math.max(best , current);

        }

        return dp[i][M] = best;


    }
}