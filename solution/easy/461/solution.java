ass Solution {
    public int hammingDistance(int x, int y) {
        int r =0;
        int t = x ^ y;
        while(t >0) {
            if(((t+1) ^ t) !=1)
                r++;
            t >>= 1;
            
        }
        return r;
    }
}
