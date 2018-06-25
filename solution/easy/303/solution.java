class NumArray {
    private int[] sums;
    public NumArray(int[] nums) {
        this.sums = new int[nums.length];
        int sum = 0;
        for(int i = 0; i<nums.length;i++) {
            sums[i] = sum + nums[i];
            sum = sums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return i== 0? sums[j]: sums[j] - sums[i-1]; 
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */