
import java.util.*;
public class NutAndBolt {
    
    static void matchPairs(char nuts[], char bolts[], int n) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nuts.length; i++){
            for(int j = 0; j < nuts.length; j++){
                if(bolts[i] >= nuts[j]) map.put(bolts[i], map.getOrDefault(bolts[i], 0) + 1);
            }
        }
        
        for(Character i : map.keySet()){
            bolts[map.get(i) - 1] = i;
            nuts[map.get(i) - 1] = i;
        }
    }


    public static void main(String[] args) {
        char[] nuts = {'@', '%', '$', '#', '^'};
        char[] bolts = {'%', '@', '#', '$', '^'};
        matchPairs(nuts, bolts, 0);
        for(int i = 0; i < nuts.length; i++){
            System.out.println(bolts[i]);
            System.out.println(nuts[i]);
        }
    }


}
