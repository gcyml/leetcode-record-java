ass Solution {
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        for(char s: S.toCharArray()) {
            if(J.indexOf(s) != -1)
                result++;
        }
        return result;
    }
}