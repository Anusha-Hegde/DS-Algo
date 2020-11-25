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

public class LLduplicates {
    public ListNode removeElements(ListNode head, int val) {
        
        while(head != null && head.val == val) head = head.next;
        
        ListNode res = head;
        
        if(head == null) return head;
        
        while(head.next != null){
            if(head.next.val == val) head.next = head.next.next;
            else head = head.next;
        }
        
        return res;
    }
}
