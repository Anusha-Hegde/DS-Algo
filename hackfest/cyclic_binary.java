package hackfest;

import java.io.*;

/*
Given a binary string, you can cyclically shift this string any number of times. 
For example, consecutively applying cyclic shift operation to the binary string "010011" you will get "100110", "001101" and so on.

For given such a string after right amount of cyclic shifts find the greatest power of 2 which string can be divisible with, if it can be divisible with arbitrarily large power print "-1".

For the result, you are required to print a single integer denoting the maximum power of 2 by which string can be divisible with.

For example if string
"0011", we can cyclically shift time to get string "1100" which in decimal is 12 and is divisible with 4, hence the answer is 2.

*/

public class cyclic_binary {
    
    
    public static void main(String[] args) throws IOException {
        
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();
        
        int max = 0;
        
        int i = 0, j = 0, index1 = 0, index2 = 0;
        
        while(j < s.length()){
            
            while(j < s.length() && s.charAt(j) == '1') j++;
            
            i = j;
            
            while(j < s.length() && s.charAt(j) == '0') j++;
            
            if(max < (j - i)){
                max = j - i;
                index1 = i;
                index2 = j;
            }
        }
        
        
        if(index1 == 0 && max < s.length()){
            
            i = s.length() - 1;
            int count = 0;
            
            while(s.charAt(i) == '0'){
                i--;
                count++;
            }
            max += count;
        }
        
        else if(index2 == s.length() && max < s.length()){
            i = 0;
            while(s.charAt(i) == '0') i++;
            
            max += i;
        }
        
        
        if(max >= 2147483647 || max == s.length())
            bufferedWriter.write(String.valueOf(-1));
        else bufferedWriter.write(String.valueOf(max));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
       
}
