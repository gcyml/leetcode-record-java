ass Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        String t = ""+x;
        char[] nums = t.toCharArray();
        for(int i=0;i<nums.length/2;i++) {
            if(nums[i] != nums[nums.length-i-1])
                return false;
        }
        return true;
    }
}
