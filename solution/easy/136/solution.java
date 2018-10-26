class Solution {
    public int singleNumber(int[] nums) {
        int a=0;
        // 因为只有一个不同数，所以相同数会相互抵消，只留唯一数
        for(int i =0; i<nums.length;i++){
            a^=nums[i];
        }
        return a;
    }
}