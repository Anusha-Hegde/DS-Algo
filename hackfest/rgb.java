package hackfest;

import java.io.*;
import java.util.*;


public class rgb {
    
    static Map<Integer, List<Integer>> r = new HashMap<>();
    static Map<Integer, List<Integer>> g = new HashMap<>();
    static Map<Integer, List<Integer>> b = new HashMap<>(); 
    static int[][] colors;
    
    public static int check(int red, int green, int blue){
        
        int rf = 0, gf = 0, bf = 0;
                    
        if(!r.containsKey(red) || !g.containsKey(green) || !b.containsKey(blue)) return 0;
            
            
        for(int j : r.get(red)){
            if(colors[j][1] <= green && colors[j][2] <= blue){
                rf = 1;
                if(colors[j][1] == green) gf = 1;
                if(colors[j][2] == blue) bf = 1;
                if(bf == 1 && gf == 1 && rf == 1) return 1;
                // break;
            }
        }
            
        if(rf == 0) return 0;

        //---------------------------------------------------------------

        

        for(int j : g.get(green)){
            if(colors[j][0] <= red && colors[j][2] <= blue){
                gf = 1;
                if(colors[j][2] == blue) return 1;
                // break;
            }
        }

        if(gf == 0) return 0;

        //----------------------------------------------------------------

        for(int j : b.get(blue)){
            if(colors[j][1] <= green && colors[j][0] <= red) return 1;
        }

        if(bf == 0) return 0;
        return 1;
    }
    
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        String[] firstMultipleInput = sc.next().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        colors = new int[n][3]; 
        
        String[] temp;
        
        for(int i = 0; i < n; i++){
            
            temp = sc.next().replaceAll("\\s+$", "").split(" ");
            
            colors[i][0] = Integer.parseInt(temp[0]);
            List<Integer> te = r.getOrDefault(colors[i][0], new LinkedList<Integer>());
            te.add(i);
            r.put(colors[i][0], te);
            
            colors[i][1] = Integer.parseInt(temp[1]);
            te = g.getOrDefault(colors[i][1], new LinkedList<Integer>());
            te.add(i);
            g.put(colors[i][1], te);
            
            colors[i][2] = Integer.parseInt(temp[2]);
            te = b.getOrDefault(colors[i][2], new LinkedList<Integer>());
            te.add(i);
            b.put(colors[i][2], te);
        }
        
        
        for(int i = 0; i < m; i++){
            
            temp = sc.next().replaceAll("\\s+$", "").split(" ");
            int red = Integer.parseInt(temp[0]);
            int green = Integer.parseInt(temp[1]);
            int blue = Integer.parseInt(temp[2]);
            
        
            
            if(check(red, green, blue) == 1) System.out.println("YES");
            else System.out.println("NO");
            
            
        }  
     
        sc.close();
    }
}
