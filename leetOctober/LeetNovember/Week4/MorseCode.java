/**
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
 * "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 * 
 * 
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. 
 * For example, "cab" can be written as "-.-..--...", (which is the concatenation "-.-." + ".-" + "-..."). 
 * We'll call such a concatenation, the transformation of a word.
 * 
 * 
 * Return the number of different transformations among all words we have
 */

public class MorseCode {
    String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for(String i : words) set.add(meth(i));
        return set.size();
    }
    
    public String meth(String word){
        String temp = "";
        for(char i : word.toCharArray()) temp += morse[i - 'a'];
        return temp;
    }
}
