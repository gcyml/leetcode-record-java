class Solution {
    public int romanToInt(String s) {
        int res = 0; 
        if(s == null) return res;
        for(int i= 0;i<s.length()-1;i++) {
            int tmp = helper(s.charAt(i));
            if(tmp < helper(s.charAt(i+1))) {
                res -= tmp;
            } else {
                res += tmp;
            }
        }
        res += helper(s.charAt(s.length()-1));
        return res;
    }
    public int helper(char s) {
        if(s == 'I') {
            return 1;
        } else if(s == 'V') {
            return 5;
        } else if(s == 'X') {
            return 10;
        } else if(s == 'L') {
            return 50;
        } else if(s == 'C') {
            return 100;
        } else if(s == 'D') {
            return 500;
        } else if(s == 'M') {
            return 1000;
        }
        return 0;
    } 
}