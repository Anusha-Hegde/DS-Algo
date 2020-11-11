package leetOctober.LeetNovember.Week2;

/**
 * Given the coordinates of four points in 2D space, return whether the four points could construct a square.
 * 
 * The coordinate (x,y) of a point is represented by an integer array with two integers.
 * 
 * Example:
 * 
 *  Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 *  Output: True

 */

public class Cartician {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        int a = -1, b = -1;
        
        int[][] res = new int[][]{p1, p2, p3, p4};
        
        for(int i = 0; i < res.length - 1; i++){
            for(int j = i + 1; j < res.length; j++){
                int t = temp(res[i], res[j]);
                if(t == 0) return false;
                if(a == t || b == t) continue;
                if(a == -1) a = t;
                else if(b == -1) b = t;
                else return false;
            }
        }
        
        return true;
    }
    
    public int temp(int[] p1, int[] p2){
        int a = p1[0] - p2[0], b = p1[1] - p2[1];
        return a * a + b * b;
    }

}
