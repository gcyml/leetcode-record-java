class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        boolean[] marked = new boolean[nums.length];
        for(int num : nums){
            marked[num-1] = true;
        }
        for(int i=0;i<marked.length;i++) {
            if(!marked[i]) {
                res.add(i+1);
            }
        }
        return res;
    }
}
