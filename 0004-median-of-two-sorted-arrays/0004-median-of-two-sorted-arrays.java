class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;
        int[]res = new int[m+n];
        int r=0; int n1=0; int n2=0;
        for(int i=0;i<m+n;i++){
            if(n1<m && n2<n){
                if(nums1[n1]<nums2[n2]){
                    res[i]=nums1[n1];
                    n1++;
                }
                else{
                    res[i]=nums2[n2];
                    n2++;
                }
            }

            else if(n1>=m){
                res[i]=nums2[n2];
                n2++;
            }

            else{
                res[i]=nums1[n1];
                n1++;
            }
        }
        
        if(res.length % 2 == 0){
            return (res[res.length/2] + res[(res.length/2) - 1])/2.0;
        }
        
        return (double)res[(res.length/2)];
    
    }
}