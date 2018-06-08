class Solution {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int num = 0;
        for(int i = len-1;i>=0;i--) {
            if(chars[i] != ' ') {
                num++;
            } else if(num != 0) break;
        }
        return num;
    }
}
