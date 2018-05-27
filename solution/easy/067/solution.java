ass Solution {
    public String addBinary(String a, String b) {
        String result ="";
        int la = a.length();
        int lb = b.length();
        if (la == 0) { return b; }
        if (lb == 0) { return a; }
        int lmax = Math.max(la, lb);
        int add = 0;
        for (int i = 0; i < lmax; i++) {
            char ca = la>i?a.charAt(la-i-1):'0';
            char cb = lb>i?b.charAt(lb-i-1):'0';
            int sum = add+cb+ca-96;
            if(sum%2==0) {
                        result = '0' +result;
                        add =sum/ 2;
                    } else{
                        result = '1' +result;
                        add = sum>2?1:0;
                    }
        }
        if(add==1)
            result = '1' +result;
        return result;
    }
   
        
}
