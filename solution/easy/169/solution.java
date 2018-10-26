class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int compare_num = nums[0];
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == compare_num) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                compare_num = nums[i];
                count = 1;
            }
            
        }
        return compare_num;
    }
}