ass Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int dup = nums[0];
        int end = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i]!=dup){
                nums[end] = nums[i];
                dup = nums[i];
                end++;
            }
        }
        return end;
    }
}
