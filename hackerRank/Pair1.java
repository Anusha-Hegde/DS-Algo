package hackerRank;

import java.io.*;
import java.util.*;


class Result {

    /*
     * Complete the 'maxPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY skillLevel
     *  2. INTEGER minDiff
     */

    public static int maxPairs(int[] skillLevel, int minDiff) {
        
        int res = 0, i = 0, j = 0;
        
        Arrays.sort(skillLevel);
        
        while(j < skillLevel.length){
            
            if(skillLevel[j] - skillLevel[i] < minDiff){
                j++;
                continue;
            }
            res++;
            i++;
            j++;
            
        }
        
        return res;
        

    }

}

public class Pair1 {
    public static void main(String[] args) throws IOException {
        
        Scanner s = new Scanner(System.in).useDelimiter("\n");
        
        int n = Integer.parseInt(s.next().replaceAll("\\s+$", ""));
        
        int[] skillLevel = new int[n];
        
        for(int i = 0; i < n; i++) skillLevel[i] = Integer.parseInt(s.next().replaceAll("\\s+$", ""));

        int minDiff = Integer.parseInt(s.next().replaceAll("\\s+$", ""));

        int result = Result.maxPairs(skillLevel, minDiff);

        System.out.println(result);
        
        s.close();
    }
}
