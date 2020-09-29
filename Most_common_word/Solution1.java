package Most_common_word;
/*
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
*/

import java.util.*;

class Solution1 {
    public String mostCommonWord(String paragraph, String[] ban) {
        
        String[] par = paragraph.replaceAll("[^A-Za-z]+"," ").split(" ");
        
        Set<String> banned = new HashSet<>(Arrays.asList(ban));
        String res = "";
        int max = 0;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(String i : par){
            i = i.toLowerCase();
            if(!banned.contains(i)) map.put(i, map.getOrDefault(i, 0) + 1); 
        }
        
        for(String i : map.keySet()){
            if(map.get(i) > max){
                max = map.get(i);
                res = i;
            }
        }
        return res;
    }
}