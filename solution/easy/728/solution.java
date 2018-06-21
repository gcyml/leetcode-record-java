class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> r = new ArrayList<>();
        for(int i = left;i<=right;i++) {
            int temp = i;
            while(temp!=0){
                int a = temp%10;
                if(a == 0 || i % a != 0) {
                    break;
                }
                temp /= 10;
            }
            if(temp==0)
                r.add(i);
        }
        return r;
    }
}
