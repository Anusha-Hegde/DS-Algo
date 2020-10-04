package Graph_Clone;

/*
for given graph create its clone
*/

import java.util.*;    
    

public class GraphClone {
    Map<Integer, Node> set = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        return dfs(node);
    }
    
    public Node dfs(Node node){
        
        if(node == null) return null;
        
        if(set.containsKey(node.val)) return set.get(node.val);
        
        Node clone = new Node(node.val);
        set.put(node.val, clone);
        for(Node i : node.neighbors){
            clone.neighbors.add(dfs(i));
        }
        return clone;
    }
}
