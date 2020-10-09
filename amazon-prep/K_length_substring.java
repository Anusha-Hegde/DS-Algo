import java.util.*;

public class K_length_substring {
    public List<String> solution(String line, int k) {
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        List<String> res = new ArrayList<String>();

        while (j < line.length()) {

            if(j - i < k){
                if(!(set.contains(line.charAt(j)))){
                    set.add(line.charAt(j));
                    j += 1;
                }
                else{
                    set.remove(line.charAt(i));
                    i += 1;
                }
            }

            if (j - i == k){
                res.add(line.substring(i, j));
                set.remove(line.charAt(i));
                i += 1;
            }
            
        }
        return res;
    }
}

// abcdefgh