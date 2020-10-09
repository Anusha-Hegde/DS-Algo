import java.util.*;

class PrisonCell {
    
    int l = 0;
    int[] t;
    
    public int[] prisonAfterNDays(int[] cells, int N) {
        
        l = cells.length;
        t = new int[l];
        
        int i = 0;
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, int[]> map2 = new HashMap<>();
        
        
        
        while(i < N){
            
            String temp = Arrays.toString(cells);
            
            System.out.println(temp);
            
            if(map1.containsKey(temp)) break;
            
            map1.put(temp, i);
            map2.put(i, cells);
            
            cells = nextDay(cells);
            i++;
            
        }
        
        if(i == N) return cells;
        return map2.get(N % (i - 1));
        
    }
    
    public int[] nextDay(int[] cell){     
        for(int j = 1; j < l - 1; j++) t[j] = cell[j - 1]==cell[j + 1] ? 1 : 0;
        return t;
    }
}