import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        
        Scanner s = new Scanner(System.in).useDelimiter("\n");

        Set<String> map = new HashSet<>();

        int n = Integer.parseInt(s.next().replaceAll("\\s", ""));

        List<String> res = new ArrayList<>();

        String[] string = s.next().split(" ");
        
        Arrays.sort(string);

        for(String i : string){
            char[] c = i.toCharArray();
            Arrays.sort(c);
            String t = new String(c);
            if(!map.contains(t)){
                res.add(i);
                map.add(t);
            }
        }

        for(String i : res){
            System.out.println(i);
        }
        
        s.close();
    }
}