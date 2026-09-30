class Solution {
    public int findLucky(int[] arr) {
        int ans[] = new int[501];

        Arrays.fill(ans,0);
        for(int i : arr){
            ans[i] += 1;
        }
        

        for(int i = ans.length - 1; i > 0; i--){
            if(ans[i] == i) return ans[i];
        }

        return -1;
    }
}