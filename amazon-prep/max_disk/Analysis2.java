package max_disk;

import java.util.*;

public class Analysis2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length];
        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < nums.length; i++){
            while(!q.isEmpty() && q.peek() < i - k + 1) q.poll(); 
            while(!q.isEmpty() && nums[q.peekLast()] > nums[i]) q.pollLast();
            q.add(i);
            res[i] = nums[q.peek()];
        }
        return res;
    }
}
