/*
Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.

Example:

Input: n = 12, primes = [2,7,13,19]
Output: 32 
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 
             super ugly numbers given primes = [2,7,13,19] of size 4.
*/






class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1) return 1;
        
        int[] res = new int[n];
        int[] index = new int[primes.length]; 
        
        res[0] = 1;
        
        for(int i = 1; i < n; i++){
            res[i] = res[index[0]] * primes[0];
            for(int j = 1; j < primes.length; j++){
                res[i] = Math.min(res[i], res[index[j]] * primes[j]);
            }
            
            for(int j = 0; j < primes.length; j++){
                if(res[i] == res[index[j]] * primes[j]) index[j] += 1;
            }
        }
        return res[n-1];
    }
}
