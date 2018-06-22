class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0) return 0;
        int sum = duration;
        for(int i=1;i<timeSeries.length;i++) {
            int diff = timeSeries[i] -timeSeries[i-1];
            if(diff >duration-1) {
                sum += duration; 
            } else {
                sum += diff;
            }
        }
        return sum;
    }
}