package hackerRank;

import java.io.*;
import java.util.*;




public class Pair2 {
    
    public static long taskOfPairing(long[] freq) {
        
        long res = 0;
        
        int i;
        
        for(i = 0; i < freq.length - 1; i++){
            
            res += freq[i] / 2;
            long rem = freq[i] % 2;
            
            if(rem == 1 && freq[i + 1] >= 1){
                freq[i + 1] -= rem;
                res++;
            }
        }
        
        if(freq.length > 0 && freq[i] > 1) res += freq[i] / 2;
        
        return res;

    }
    
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        long[] arr = new long[n];
        
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        long result = taskOfPairing(arr);

        System.out.println(result);
        sc.close();
    }
}
