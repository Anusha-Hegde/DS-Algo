package leetOctober.LeetDecmeber.week1;

import java.util.Random;

import leetOctober.LeetDecmeber.ListNode;

/**
 * 
 * Given a singly linked list, return a random node's value from the linked
 * list. Each node must have the same probability of being chosen.
 * 
 * Follow up: What if the linked list is extremely large and its length is
 * unknown to you? Could you solve this efficiently without using extra space?
 */


public class random {
    
    ListNode head;
    Random random;
    
    public random(ListNode head) {
        this.head = head;       
        random = new Random();        
    }
    
    public int getRandom() {
        
        ListNode curr = head;
        int res = curr.val;
        
        for(int i = 1; curr.next != null; i++){
            curr = curr.next;
            if(random.nextInt(i + 1) == i) res = curr.val;                        
        }
        
        return res;
    }
}
