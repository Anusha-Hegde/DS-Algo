package CriticalConnections;

import java.util.*;

public class Main {

    static List<List<Integer>> res = new ArrayList<List<Integer>>();
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static List<Integer> temp;
    static int[] vis;

    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        vis = new int[n];
        
        for(int i = 0; i < connections.size(); i++){
            
            temp = graph.getOrDefault(connections.get(i).get(0), new ArrayList<Integer>());
            temp.add(connections.get(i).get(1));
            graph.put(connections.get(i).get(0), temp);

            temp = graph.getOrDefault(connections.get(i).get(1), new ArrayList<Integer>());
            temp.add(connections.get(i).get(0));
            graph.put(connections.get(i).get(1), temp);
            
        }

        dfs(0, -2);

        return res;
        
    }

    public static void dfs(int node, int rank){
        for(int i : graph.get(node)){
            
        }
    }
    public static void main(String[] args) {
        List<Integer> map = new ArrayList<>({1, 2, 3, 4, 5});
        
    }
}
