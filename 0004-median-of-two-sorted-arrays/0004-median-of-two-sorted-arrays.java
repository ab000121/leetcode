class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int ans[] = new int[m+n];


        int n1 = 0; 
        int n2 = 0; 
        

        for(int i = 0; i < m+n; i++){
            if(n1 < m && n2 < n){

                if(nums1[n1] <= nums2[n2]){
                    ans[i] = nums1[n1];
                    n1++;
                }
                else{
                    ans[i] =  nums2[n2];
                    n2++;
                }

            }
            else if(n1 < m){
                ans[i] = nums1[n1];
                n1++;
            }
            else{
                ans[i] = nums2[n2];
                n2++;
            }

        }

        if((m+n) % 2 == 0){
            return (ans[(m+n)/2] + ans[(m+n)/2 - 1]) / 2.0;
        }

        return (double)ans[(m+n)/2];

    }
}