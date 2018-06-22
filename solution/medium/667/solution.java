class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int left = 1, right = n;
        for(int i = 0; left <= right; i++) {
            res[i] = k > 1 ? (k-- % 2 == 0 ? right-- : left++) : left++;  //从最大和最小数轮流取值
        }
        return res;
    }
}