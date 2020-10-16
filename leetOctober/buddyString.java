package leetOctober;

import java.util.*;

class Solution {
    public boolean buddyStrings(String As, String Bs) {
        
        if(As.length() != Bs.length() || As.length() <= 1) return false;
        
        int l = As.length();
        
        char[] A = As.toCharArray();
        
        if(As.equals(Bs)){
            Set<Character> set = new HashSet<>();
            for(char i : A){
                if(set.contains(i)) return true;
                set.add(i);
            }
            return false;
        }
        
        
        int flag = 0;
        char ac = 0, bc = 0;
        char[] B = Bs.toCharArray();
        
        
        for(int i = 0; i < l && flag < 3; i++){
            if(A[i] == B[i]) continue;
            flag++;
            if(flag == 1){
                ac = A[i];
                bc = B[i];
            }
            if(flag == 2 && (ac != B[i] || bc != A[i])) return false;
        }
        
        
        if(flag != 2) return false;
        return true;
    }
}