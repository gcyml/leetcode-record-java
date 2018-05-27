ass Solution {
    public int lengthOfLastWord(String s) {
        String[] aa = s.split(" ");
        if(aa.length==0)
            return 0;
        return aa[aa.length-1].length();
    }
}
