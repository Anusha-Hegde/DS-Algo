package hackerRank;

import java.io.IOException;
import java.util.Scanner;

public class magic_square {
    static int formingMagicSquare(int[][] s) {

        int[][][] temp = new int[][][]{
            {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}}, 
            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}}, 
            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}}, 
            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
        };


        int res = Integer.MAX_VALUE;

        for(int i = 0; i < 8; i++){
            int curr = 0;
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    curr += Math.max(temp[i][j][k], s[j][k]) - Math.min(temp[i][j][k], s[j][k]);
                }
            }
            res = Math.min(res, curr);
        }

        return res;

    }

    public static void main(String[] args) throws IOException {

        
        
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = sc.next().split(" ");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        System.out.println(result);

        sc.close();
    }   
}
