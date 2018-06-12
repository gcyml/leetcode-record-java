class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int[] tmp = new int[nums.length];
        List<Integer> res = new ArrayList<>();
        for(int i=0;i < nums.length;i++) {
            if(++tmp[nums[i]-1] == 2) {
                res.add(nums[i]);
            }
        }
        return res;
        
    }
}
