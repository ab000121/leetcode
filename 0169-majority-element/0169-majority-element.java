class Solution {
    public int majorityElement(int[] nums) {
        int majElement = nums[0];
        int count = 1;

        for(int num : nums){
            if(majElement == num) count++;

            else{
                count--;
                if(count == 0) {
                    majElement = num;
                    count++;
                }
            }
        }

        return majElement;
    
    }
}