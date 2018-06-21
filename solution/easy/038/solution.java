class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        if(n==1) {
            sb.append("1");
        } else {
            String sayStr = countAndSay(n-1);
            char[] character = sayStr.toCharArray();
            for(int i=0;i<character.length;) {
                int j = i;
                while(++j < character.length) {
                    if(character[j] != character[i])
                        break;
                }
                sb.append(String.valueOf(j-i) + character[i]); 
                i = j;
            }
        }
        return sb.toString();
    }
}
