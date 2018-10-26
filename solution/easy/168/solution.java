class Solution {
    public String convertToTitle(int n) {
        String res = "";
        while(n != 0) {
            n--;
            char letter = (char)(n %26 + 'A');
            res = letter + res;
            n /= 26;
      
        }
        return res;
    }
}