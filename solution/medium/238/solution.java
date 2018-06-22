class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        boolean hasOneZero = false;
        int product = 1;
        for(int tmp : nums) {
            if(tmp == 0) {
                if(hasOneZero) {
                    product = 0;
                    break;
                } else {
                     hasOneZero = true;
                }
            } else {
                product *= tmp;
            }
        }
        if(product != 0) {
            for(int i = 0;i<nums.length;i++) {
                if(hasOneZero) {
                    if(nums[i] == 0) {
                        res[i] = product;
                        break;
                    }
                } else {
                    res[i] = product/nums[i];
                }
            }
        }
        
        
        return res;
    }
}