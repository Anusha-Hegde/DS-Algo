package leetOctober.LeetNovember;
/**
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where 
 * edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, 
 * you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. 
 * Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
 * 
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 */

import java.util.*;

public class MinHeightTress1 {
    Map<Integer, List<Integer>> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    int[] vis;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        int[] arr = new int[n];

        List<Integer> temp;

        for (int[] a : edges) {
            temp = map.getOrDefault(a[0], new ArrayList<Integer>());
            temp.add(a[1]);
            map.put(a[0], temp);
            temp = map.getOrDefault(a[1], new ArrayList<Integer>());
            temp.add(a[0]);
            map.put(a[1], temp);
        }

        for (Map.Entry<Integer, List<Integer>> i : map.entrySet()) {
            vis = new int[n];
            arr[i.getKey()] = dfs(i.getKey());
        }

        int min = arr[0];
        set.add(0);

        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                set = new HashSet<>();
                min = arr[i];
                set.add(i);
            }
            if (arr[i] == min)
                set.add(i);
        }
        for (int i : set)
            res.add(i);
        return res;
    }

    public int dfs(int node) {
        if (vis[node] == 1)
            return 0;
        vis[node] = 1;
        int m = 0;
        for (int i : map.get(node))
            m = Math.max(m, dfs(i));
        return m + 1;
    }
}
