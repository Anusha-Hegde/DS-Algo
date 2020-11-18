package leetOctober.LeetNovember.Week3;

/**
 * There is a special square room with mirrors on each of the four walls.  Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.

The square room has walls of length p, and a laser ray from the southwest corner first meets the east wall at a distance q from the 0th receptor.

Return the number of the receptor that the ray meets first.  (It is guaranteed that the ray will meet a receptor eventually.)
 */

public class mirror {
    public int mirrorReflection(int p, int q) {
        while(p % 2 == 0 && q % 2 == 0){
            p /= 2;
            q /= 2;
        }
        if(p % 2 == q % 2) return 1;
        if(p % 2 == 0) return 2;
        return 0;        
    }
}


/**
 * 
 * To solve the problem we extend both p and q walls until they are equal.
 * 
 * Then, if number of reflections is odd then ray meets recepter 2 in the top left (p = even, q = odd).
 * 
 * if number of reflections is even (and p is odd), it meets the recepter 0 or 1 based on q.
 */
