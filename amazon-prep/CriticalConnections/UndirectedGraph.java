package CriticalConnections;

import java.util.*;

public class UndirectedGraph {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    List<Integer> temp;
    List<List<Integer>> res = new ArrayList<>();
    int[] vis;
    int[] who;
    int[] count;

    public List<List<Integer>> criticalConnections(int n, int[][] connections) {

        who = new int[n];
        count = new int[n];

        for (int i = 0; i < n; i++){
            count[i] = -2;
            who[i] = i;
        }

        vis = new int[n];

        for (int i = 0; i < connections.length; i++) {

            temp = graph.getOrDefault(connections[i][0], new ArrayList<Integer>());
            temp.add(connections[i][1]);
            graph.put(connections[i][0], temp);

            temp = graph.getOrDefault(connections[i][1], new ArrayList<Integer>());
            temp.add(connections[i][0]);
            graph.put(connections[i][1], temp);

        }

        who[0] = dfs(0, 0);

        for (int i = 0; i < connections.length; i++) {
            if (who[connections[i][0]] != who[connections[i][1]]) {
                res.add(Arrays.asList(connections[i][0], connections[i][1]));
            }
        }

        return res;

    }

    public int dfs(int node, int pcount) {

        if (vis[node] == 0) {

            count[node] = pcount;

            vis[node] = 1;

            for (int i : graph.get(node)) {

                if(count[i] != pcount - 1) who[node] = Math.min(who[node], dfs(i, pcount + 1));
                    
            }

            // count
        }

        return who[node];
    }

    public static void main(String[] args) {

        int[][] arr = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 1, 3 }, { 3, 4 }, { 4, 5 }, { 5, 3 }, { 4, 6 } };

        UndirectedGraph obj = new UndirectedGraph();

        System.out.println(obj.criticalConnections(7, arr));
    }
}
