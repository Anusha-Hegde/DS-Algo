package leetOctober.LeetDecmeber.Week2;


/**
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 */

public class Spiral {
    
    public int[][] generateMatrix(int n) {
        
        int[][] res = new int[n][n];
        int i = 0, j = 0, num = 1;
        
        while(num <= n * n){
            while(j < n && res[i][j] == 0) res[i][j++] = num++;
            j--;
            i++;
            while(i < n && res[i][j] == 0) res[i++][j] = num++;
            i--;
            j--;
            while(j >= 0 && res[i][j] == 0) res[i][j--] = num++;
            j++;
            i--;
            while(i >= 0 && res[i][j] == 0) res[i--][j] = num++;
            i++;
            j++;
        }
        
        return res;
    }
    
}
