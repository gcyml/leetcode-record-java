class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] res = new int[2];
        int[] dp = new int[numbers.length];
        for(int i=0;i<numbers.length;i++) {
            for(int j = i-1;j>=0 && dp[j] <= numbers[i];j--) {
                if(dp[j] == numbers[i]) {
                    res[0] = j+1;
                    res[1] = i+1;
                    return res;
                }
            }
            dp[i] = target - numbers[i];
            
        }
        return res;
        
    }
}