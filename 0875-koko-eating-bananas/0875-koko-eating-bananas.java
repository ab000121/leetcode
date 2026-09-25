class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=piles[0];
        for(int i:piles){
            max=Math.max(max,i);
        }

        int left=1;
        int right=max;
        int ans=0;

        while(left<=right){
            int mid=left+(right-left)/2;
            long totalHrs=0;

            for(int i:piles){
                totalHrs=totalHrs+(i+mid-1)/mid;
            }
            if(totalHrs<=h){
                ans=mid;
                right=mid-1;
            }
            else left=mid+1;
            
        }
        return ans;
    }
}