class Solution {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length+1];  
 
        if (digits.length == 0 || digits == null) {
            return null;
        }
        boolean plus = true;
        for(int i=digits.length-1;i>=0;i--) {
            if(plus) {
                if(digits[i]==9) {
                    digits[i] = 0;
                    plus = true;
                }else {
                    digits[i]++;
                    plus = false;
                }                    
            }               
        }
        if(plus) {
            int[] tmp = {1};
            System.arraycopy(tmp, 0, result, 0, tmp.length);
            System.arraycopy(digits, 0, result, tmp.length, digits.length);
            return result;
        } else
            return digits;
    }
}
