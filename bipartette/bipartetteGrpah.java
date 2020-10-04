package bipartette;

public class bipartetteGrpah {

    public static boolean isBipartite(int[][] graph) {

        int[] vis = new int[graph.length];

        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == 0) {
                vis[i] = 1;
                dfs(graph, i, vis);
            }
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j : graph[i]) {
                if (vis[i] == vis[j])
                    return false;
            }
        }

        return true;

    }

    public static void dfs(int[][] graph, int node, int[] vis) {
        for (int i : graph[node]) {
            if (vis[i] == 0) {
                vis[i] = -vis[node];
                dfs(graph, i, vis);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = { { 1 }, { 0 }, { 4 }, { 4 }, { 2, 3 } };
        System.out.println(isBipartite(graph));
    }
}
