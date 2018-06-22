class Solution {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0;  
        for (int i = 0, maxn = 0; i < arr.length; i++) {  
            maxn = Math.max(arr[i], maxn);  
            if (maxn == i) ans++;  // 最大值出现在了他原本的位置，则此时完成了任务
        }  
        return ans; 
    }
}