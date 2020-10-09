package SourceToSink;

import java.util.*;

public class Main {

    public static List<List<Integer>> res = new ArrayList<List<Integer>>();
    public static List<Integer> ans = new ArrayList<Integer>();


    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        ans.add(0);
        
        dfs(graph, 0);

        return res;
    }

    public static void dfs(int[][] graph, int node){
        if(node == graph.length - 1){
            res.add(new ArrayList<Integer>(ans));
        }
        else{
            for(int i : graph[node]){
                ans.add(i);
                dfs(graph, i);
                ans.remove(ans.size() - 1);
            }
        }
        
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{ {1, 3}, {2}, {3}, {} };
        System.out.println(allPathsSourceTarget(graph));
    }
}
