import java.util.*;

class check {
    public static void main(String[] args) {
        Deque<Character> q = new ArrayDeque<Character>();
        q.add('a');
        q.add('b');
        q.add('c');
        q.add('d');
        q.add('e');
        System.out.println(q);
        q.poll();
        System.out.println(q);
        q.pollLast();
        System.out.println(q);
        q.pollFirst();
        System.out.println(q);
        String res = "";
        for(char i : q) res += i;
        System.out.println(res);
        q.contains(arg0)
    }
}