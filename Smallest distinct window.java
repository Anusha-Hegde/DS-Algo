import java.util.*;

class Smallest_distinct_window {
    public int check(String s) {

        int res1 = 2147483647;
        Map<Character, Integer> map = new HashMap<>();
        Deque<Character> q = new ArrayDeque<>();
        Set<Character> set = new HashSet<>();
        Set<Character> set1 = new HashSet<>();

        for (Character i : s.toCharArray()) {
            set.add(i);
        }

        for (Character i : s.toCharArray()) {

            map.put(i, map.getOrDefault(i, 0) + 1);
            q.add(i);
            set1.add(i);

            if(map.get(q.peek()) == 1 && map.get(q.peekLast()) == 1 && set.size() <= set1.size()){
                res1 = Math.min(res1, q.size());
            }

            while (!q.isEmpty() && map.containsKey(q.peek()) && map.get(q.peek()) > 1) {
                char temp = q.poll();
                map.put(temp, map.get(temp) - 1);
            }
        }
        while (!q.isEmpty() && map.containsKey(q.peekLast()) && map.get(q.peekLast()) > 1) {
            char temp = q.pollLast();
            map.put(temp, map.get(temp) - 1);
        }

        res1 = Math.min(res1, q.size());

        return res1;
    }

    public static void main(String[] args) {
        Smallest_distinct_window obj = new Smallest_distinct_window();
        System.out.println(obj.check("lcpsklryvmcpjnbpbwllsrehfmxrkecwitrsglrexvtjmxypunbqfgxmuvgfajclfvenhyuhuorjosamibdn"));
    }
}