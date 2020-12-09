package leetOctober.LeetDecmeber.Favourites;

import java.util.Random;

import leetOctober.LeetDecmeber.ListNode;

/**
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Example 1:

Input
["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
[[[1, 2, 3]], [], [], [], [], []]
Output
[null, 1, 3, 2, 2, 3]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.getRandom(); // return 1
solution.getRandom(); // return 3
solution.getRandom(); // return 2
solution.getRandom(); // return 2
solution.getRandom(); // return 3
// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.

Follow up:

    What if the linked list is extremely large and its length is unknown to you?
    Could you solve this efficiently without using extra space?


 */


/**
 * Reservoir sampling: Problem:

    Choose k entries from n numbers. Make sure each number is selected with the probability of k/n

Basic idea:

    Choose 1, 2, 3, ..., k first and put them into the reservoir.
    For k+1, pick it with a probability of k/(k+1), and randomly replace a number in the reservoir.
    For k+i, pick it with a probability of k/(k+i), and randomly replace a number in the reservoir.
    Repeat until k+i reaches n

This problem is a special case of k = 1

 */

public class RandomNode {
    ListNode head;
    Random random;
    
    public RandomNode(ListNode head) {
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
