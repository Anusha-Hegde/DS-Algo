import java.util.*;

class SmallestDistWin {
    public int check(String s) {

        int res = 2147483647;
        Map<Character, Integer> map = new HashMap<>();
        Deque<Character> q = new ArrayDeque<>();
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        char temp;

        for (Character j : s.toCharArray()) {
            set1.add(j);
        }

        for (Character i : s.toCharArray()) {
            
            map.put(i, map.getOrDefault(i, 0) + 1);
            q.add(i);
            set2.add(i);            

            if (set2.size() == set1.size()) {

                while (map.get(q.peek()) > 1) {
                    temp = q.poll();
                    map.put(temp, map.get(temp) - 1);
                }
    
                res = Math.min(res, q.size());                

            }
        }

        return res;
    }

    public static void main(String[] args) {
        SmallestDistWin obj = new SmallestDistWin();
        System.out.println(obj.check("lcpsklryvmcpjnbpbwllsrehfmxrkecwitrsglrexvtjmxypunbqfgxmuvgfajclfvenhyuhuorjosamibdn"));
    }
}