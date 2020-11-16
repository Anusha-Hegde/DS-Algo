package leetOctober.LeetNovember.Week3;


/**
 * 
 * Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

    B.length >= 3
    There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]

(Note that B could be any subarray of A, including the entire array A.)

Given an array A of integers, return the length of the longest mountain. 

Return 0 if there is no mountain.


 */
class Solution {
    public int longestMountain(int[] A) {
        int ans = 0;
        for(int i = 0; i < A.length - 1;){
            if(A[i] < A[i + 1]){
                int j = i;
                while(j < A.length - 1 && A[j] < A[j + 1]) j++;
                if(j == A.length - 1 || A[j] == A[j + 1] ){
                    i = j + 1;
                    continue;
                }
                while(j < A.length - 1 && A[j] > A[j + 1]) j++;
                ans = Math.max(j - i + 1, ans);
                i = j;
            }
            else i++;
        }
        return ans;
    }
}