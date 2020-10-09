package hackfest;

import java.io.*;
import java.util.*;

/*
In a new numbers game, players are given aninteger array of length.

The players take turns, in each turn the current player does the following:

    If a player can reorder the array elements to form a strictly increasing sequence, they win the game.
    Otherwise the player can choose any element and remove it from the array.

Determine which player wins the game if both players play optimally and the first player plays first.

Example: 1 2 2 3 

The given sequence is not strictly increasing. So, the first player has to remove an element. 
If the player removes any 2, this will lead to a winning state for the second player. So, it would be better if 1 or 3 is removed.
Let's assume the player removes 1. The second player can not reorder the elements and win. So, the second player has to remove an element. 
If the player removes any 2, this will lead to a winning state for the first player. So, it would be better if 3 is removed.

The remaining sequence is 2 2 which is not a strictly increasing sequence. So, the first player has to remove 2.

The second player wins since the remaining element is 2 and it is considered a strictly increasing sequence.

*/

public class strict_increase {
    
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        int t = Integer.parseInt(sc.next().replaceAll("\\s+$", ""));
        
        while(t-- > 0){
            
            int n = Integer.parseInt(sc.next().replaceAll("\\s+$", ""));
            
            Set<Integer> set = new HashSet<>();
            
            int rep = 0;
            
            List<Integer> arr = new ArrayList<>();
            
            int i, temp;
            
            String[] a = sc.next().split(" ");
            
            for(i = 0; i < n; i++){
                temp = Integer.parseInt(a[i]);
                arr.add(temp);
                if(set.contains(temp)) rep++;
                set.add(temp);
            }
            
            Collections.sort(arr);
            
            int res = 1;
            int j = 0;
            
            while(j < arr.size() - 1){
                    
                if(arr.get(j) == arr.get(j + 1)){
                    
                    if(rep == 1){
                        
                        if(j - 1 >= 0){
                            arr.remove(j - 1);
                            j -= 1;
                        }
                        
                        else if(j + 2 < arr.size()) arr.remove(j + 2);
                        
                        else{
                            arr.remove(j);
                            rep -= 1;
                        }
                        
                        res *= -1;
                    }
                    
                    else{
                        arr.remove(j);
                        rep -= 1;
                        res *= -1; 
                    }                
                    
                }
                
                else j++;
                
            }

                    
            
            if(res == 1) System.out.println("First");
            else System.out.println("Second");
            
        }
            sc.close();
        
    }
}
