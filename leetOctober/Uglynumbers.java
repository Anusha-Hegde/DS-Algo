/**
 * Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note: 1 is typically treated as an ugly number.
 */


public class Uglynumbers {
    public int nthUglyNumber(int n) {
        int two = 0, three = 0, five = 0;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i++){
            res[i] = Math.min(res[two] * 2, Math.min(res[three] * 3, res[five] * 5));
            if(res[i] == res[two] * 2) two++;
            if(res[i] == res[three] * 3) three++;
            if(res[i] == res[five] * 5) five++;
        }
        return res[n - 1];
    }
}
