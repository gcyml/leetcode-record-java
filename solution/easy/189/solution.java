class Solution {
    public void rotate(int[] nums, int k) {
        if(k >= nums.length) {
            k = k% nums.length;
        }
        int[] tmp = new int[k];
        for(int i=nums.length-k;i<nums.length;i++) {
            tmp[i+k-nums.length] = nums[i];
        } 
        for(int i=nums.length-k-1;i>=0;i--){
            nums[i+k] = nums[i];
        }
        for(int i = 0;i<k;i++) {
            nums[i] = tmp[i];
        }
        
    }
}