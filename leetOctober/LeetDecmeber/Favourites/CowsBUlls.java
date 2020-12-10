package leetOctober.LeetDecmeber.Favourites;

/**
 * You are playing the Bulls and Cows game with your friend.

You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:

    The number of "bulls", which are digits in the guess that are in the correct position.
    The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.

Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.
 */


//One read solution
public class CowsBUlls {
    
    public String getHint(String s, String g) {
        
        int b = 0, c = 0;
        int[] sa = new int[10];
        int[] ga = new int[10];
        
        for(int i = 0; i < s.length(); i++){
            
            int sc = s.charAt(i) - '0', gc = g.charAt(i) - '0';
            
            if(sc == gc){
                b++;
                continue;
            }
            
            if(sa[gc] > 0){
                c++;
                sa[gc]--; 
            }
            else ga[gc]++;
            
            if(ga[sc] > 0){
                c++;
                ga[sc]--;
            }
            else sa[sc]++;
        }
        
        return Integer.toString(b) + "A" + Integer.toString(c) + "B";
        
    }
}


//O(n)
/**
 * public String getHint(String s, String g) {
        
        int b = 0, c = 0;
        int[] sa = new int[10];
        
        for(int i = 0; i < s.length(); i++) sa[s.charAt(i) - '0']++;

        for(int i = 0; i < s.length(); i++){
            
            int sc = s.charAt(i) - '0', gc = g.charAt(i) - '0';
            
            if(sc == gc) b++;
            if(sa[gc]-- > 0) c++;
        }
        
        return Integer.toString(b) + "A" + Integer.toString(c - b) + "B";
        
    }
 */
