package leetOctober;

import java.util.*;

/*

Given a string s, remove duplicate letters so that every letter appears once and only once. 
You must make sure your result is the smallest in lexicographical order among all possible results.
*/

public class RemDupl {
    
    public String removeDuplicateLetters(String s) {
        
        Map<Character, Integer> map = new HashMap<>();        
        Deque<Character> q = new ArrayDeque<Character>();
        // Set<Character> set = new HashSet<>();
        
        for(char i : s.toCharArray()) map.put(i, map.getOrDefault(i, 0) + 1);
        
        for(char i : s.toCharArray()){
            
            map.put(i, map.get(i) - 1);
            
            if(q.contains(i)) continue;
            
            if(q.isEmpty() || i > q.peekLast()) q.add(i);
            
            else{
                while(!q.isEmpty() && i < q.peekLast() && map.get(q.peekLast()) > 0) q.pollLast();
                q.add(i);
            }
            
            
        }

        
        String res = "";
        
        for(char i : q) res += i;
        return res;
    }
}
