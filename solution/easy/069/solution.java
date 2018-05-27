ass Solution {
    public int mySqrt(int x) {
        // 如果初始值取0x5f37642f，则会进一步加快计算速度
        double x1 = x/2.0;
        double x2 = 0.0, err = x2 - x1;
        while(Math.abs(err)>0.00000001){
            x2 = x1 - (x1 * x1 - x) / (2 * x1);
            err = x2 - x1;
            x1 = x2;
        }
        return (int)x2;
    }
}
