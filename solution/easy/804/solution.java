class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String morseCodeList[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."}; 
        HashSet <String> set = new HashSet<>();
        for(String word : words) {
            StringBuilder m = new StringBuilder();
            for(char letter : word.toCharArray()) {
                m.append(morseCodeList[letter-'a']);
            }
            String str = m.toString();
            set.add(m.toString());
        }
        return set.size();
    }
}
