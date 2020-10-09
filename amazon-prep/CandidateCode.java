// package techgig;

import java.util.*;

public class CandidateCode {

    static int count = 0, res = 0;
    static int[][] graph;
    static int r, c;

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        String s = sc.next();

        String[] t = s.split(" ");

        r = Integer.parseInt(t[0]);
        c = Integer.parseInt(t[1]);

        graph = new int[r][c];

        for (int i = 0; i < r; i++) {
            s = sc.next();
            t = s.split(" ");
            for(int j = 0; j < c; j++) graph[i][j] = Integer.parseInt(t[j]);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (graph[i][j] == 1){
                    count = 0;
                    dfs(i, j);
                    res = Math.max(res, count);
                }
            }
        }

        System.out.println(res);
        sc.close();

    }

    public static void dfs(int i, int j) {

        if ((i < r) && (j < c) && (i >= 0) && (j >= 0) && graph[i][j] == 1) {
            graph[i][j] = 0;

            count++;

            dfs(i, j + 1);
            dfs(i, j - 1);
            dfs(i - 1, j);
            dfs(i + 1, j);
        }
        return;

    }
}