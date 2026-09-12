class Solution {

    int binarySearch(int[] nums, int left, int right, int target){
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }



    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length-1;
        int secondHalf = 0;
        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] >= nums[0]) start = mid+1;
            else {
                secondHalf = mid;
                end = mid-1;
            }
        }
        if(secondHalf == 0)
            return binarySearch(nums, 0 , nums.length-1, target);
        
        
        if(target < nums[0])
            return binarySearch(nums, secondHalf , nums.length-1, target);
        
        else
             return binarySearch(nums, 0 , secondHalf-1 , target);
        

       

    }
}