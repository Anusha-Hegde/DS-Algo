import leetOctober.LeetDecmeber.ListNode;

/**
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 * 
 * Return the decimal value of the number in the linked list.
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


 //Simple solution
public class ConvertLLtodec {
    
    public int getDecimalValue(ListNode head) {

        int res = 0;

        while(head != null){
            res *= 2;
            res += head.val;
            head = head.next;
        }
        return res;
    }
}

//Dp Solution
public class ConvertLLtodec2 {
    int res = 0;
    
    public int getDecimalValue(ListNode head) {
        getPos(head);
        return res;
    }
    
    public int getPos(ListNode node){
        if(node == null) return 0;
        int pos = getPos(node.next);
        res += node.val * (int)Math.pow(2, pos);
        return pos + 1;
    }
}