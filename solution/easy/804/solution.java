ass Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String morseCodeList[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."}; 
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) {
            String m = "";
            for(char letter : word.toCharArray()) {
                m +=  morseCodeList[letter-'a'];
            }
            if(map.containsKey(m)) {
                map.put(m, map.get(m)+1);
            } else {
                 map.put(m, 1);
            }
        }
        return map.size();
    }
}
