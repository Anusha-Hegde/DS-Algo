package leetOctober.LeetNovember.Week4;

import java.util.*;

/**
 * Given a string s and an integer k, return the length of the longest substring of s such that 
 * the frequency of each character in this substring is greater than or equal to k.
 * 
 * Input: s = "aaabb", k = 3
 * Output: 3
 * Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
 */

public class LongString {
    int res = 0;
    
    public int longestSubstring(String s, int k) {
        for(int i = 0; i < s.length(); i++) dp(s.substring(i, s.length()), k);
        return res;
    }
    
    public void dp(String s, int k){
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            int ch = s.charAt(i) - 'a';
            arr[ch] += 1;
            if(arr[ch] >= k){
                if(set.contains(ch)) set.remove(ch);
                if(set.size() == 0) res = Math.max(res, i + 1);
            }
            else set.add(ch);
        }
    } 
}
