package largest_item_association;


import java.util.*;

public class LargestItemAssociation{
    public List<String> largestItemAssociation(List<PairString> itemAssociation) {

        List<String> res = new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Set<String> vis = new HashSet<String>();


        //create adjacency map
        for(PairString i : itemAssociation){
            List<String> temp = map.getOrDefault(i.first, new ArrayList<String>());
            temp.add(i.second);
            map.putIfAbsent(i.first, temp);
            temp = map.getOrDefault(i.second, new ArrayList<String>());
            temp.add(i.first);
            map.putIfAbsent(i.second, temp);
        }

        System.out.println(map);


        for(String k : map.keySet()){
            if(!vis.contains(k)){     

                List<String> curr = new ArrayList<String>();
                Queue<String> q = new ArrayDeque<String>();
                q.add(k);
                while(!q.isEmpty()){
                    String temp = q.poll();
                    vis.add(temp);
                    curr.add(temp);
                    for(String j : map.get(temp).toArray(new String[map.get(temp).size()])){
                        if(!vis.contains(j)) q.add(j);
                    }
                }
                Collections.sort(curr);
                if(curr.size() > res.size()) res = curr;
                else if(curr.size() == res.size() && (curr.get(0).compareTo(res.get(0)) < 0)) res = curr;
            }
        }
		return res;
    }
    
}
