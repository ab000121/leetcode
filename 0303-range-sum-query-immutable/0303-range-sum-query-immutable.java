class NumArray {
    int pfx[];
    public NumArray(int[] nums) {
        pfx = new int[nums.length];

        pfx[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            pfx[i] = pfx[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) return pfx[right]; 
        return pfx[right] - pfx[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */