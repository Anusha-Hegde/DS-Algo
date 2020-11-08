package leetOctober.LeetNovember.Week1;

import java.util.*;

public class MinHeightTrees2 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if(n == 1) return Arrays.asList(new Integer[]{0});
        if(n == 2) return Arrays.asList(new Integer[]{0, 1});
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> temp;
        List<Integer> res = new ArrayList<>();
        
        for(int[] a : edges){
            temp = map.getOrDefault(a[0], new HashSet<>());
            temp.add(a[1]);
            map.put(a[0], temp);
            temp = map.getOrDefault(a[1], new HashSet<>());
            temp.add(a[0]);
            map.put(a[1], temp);
        }
        
        temp = new HashSet<>();
        
        for(int i : map.keySet()){
            if(map.get(i).size() == 1) temp.add(i);
        }
        
        while(n > 2) {
            Set<Integer> t = new HashSet<>();
            for(int i : temp){
                for(int j : map.get(i)){
                    map.get(j).remove(i);
                    map.remove(i);
                    if(map.get(j).size() == 1) t.add(j);
                }
            }
            n -= temp.size();
            temp = t;
        }
        for(int i : map.keySet()) res.add(i);
        return res;
    }
}
