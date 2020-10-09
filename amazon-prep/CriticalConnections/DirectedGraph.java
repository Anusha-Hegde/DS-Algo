package CriticalConnections;

import java.util.*;

public class DirectedGraph {

    Map<Integer, List<Integer>> graph = new HashMap<>();
    List<Integer> temp;
    List<List<Integer>> res = new ArrayList<>();
    int[] vis;
    int[] who;

    public List<List<Integer>> criticalConnections(int n, int[][] connections) {

        who = new int[n];

        for (int i = 0; i < n; i++)
            who[i] = i;

        vis = new int[n];

        for (int i = 0; i < connections.length; i++) {

            temp = graph.getOrDefault(connections[i][0], new ArrayList<Integer>());
            temp.add(connections[i][1]);
            graph.put(connections[i][0], temp);

        }

        who[0] = dfs1(0);

        for (int i = 0; i < connections.length; i++) {
            if (who[connections[i][0]] != who[connections[i][1]]) {
                res.add(Arrays.asList(connections[i][0], connections[i][1]));
            }
        }

        return res;

    }

    public int dfs1(int node) {

        if (vis[node] == 0) {
            vis[node] = 1;

            if (!graph.containsKey(node))
                return -1;

            for (int i : graph.get(node)) {

                int t = dfs1(i);

                if (t >= 0) who[node] = Math.min(who[node], t);

            }
        }

        return who[node];
    }

    public static void main(String[] args) {

        int[][] arr = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 1, 3 }, { 3, 4 }, { 4, 5 }, { 5, 3 }, { 4, 6 } };

        DirectedGraph obj = new DirectedGraph();

        System.out.println(obj.criticalConnections(7, arr));

        // for (int i = 0; i < obj.who.length; i++) System.out.println(i + " and " +
        // obj.who[i]);
    }
}
