// package hackerRank.test2;

import java.util.*;

class ways {
    public static void main(String args[]) throws Exception {

        Scanner s = new Scanner(System.in).useDelimiter("\n");
        String[] inp = s.next().split(" ");

        int x1 = Integer.parseInt(inp[0]);
        int y1 = Integer.parseInt(inp[1]);
        int x2 = Integer.parseInt(inp[2]);
        int y2 = Integer.parseInt(inp[3]);

        System.out.println(ans(x1, y1, x2, y2));
        s.close();
    }

    public static int ans(int x1, int y1, int x2, int y2) {

        if (x1 > x2 || y1 > y2)
            return -1;

        if (x1 == x2 && y1 == y2)
            return 0;

        if (x1 == x2 || y1 == y2)
            return 1;

        int xdiff = x2 - x1;
        int ydiff = y2 - y1;

        int sum1 = 1;
        int i;

        for (i = 2; i <= (xdiff + ydiff); i++)
            sum1 *= i;

        int sum2 = 1;

        for (i = 1; i <= xdiff; i++)
            sum2 *= i;
        for (i = 1; i <= ydiff; i++)
            sum2 *= i;

        return sum1 / sum2;
    }
}