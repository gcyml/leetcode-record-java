class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
           if(c >= 'a' && c <= 'z') {
                sb.append(c);
            } 
            if(c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        s = sb.toString();
        int left = 0, right = s.length()-1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
        
    }
    
}