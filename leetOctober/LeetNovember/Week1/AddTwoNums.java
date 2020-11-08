package leetOctober.LeetNovember.Week1;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The most significant digit comes first and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

/**
 * public class ListNode { 
 * int val; 
 * ListNode next; 
 * ListNode() {} 
 * ListNode(int val) { this.val = val; } 
 * ListNode(int val, ListNode next) { 
 *      this.val = val; 
 *      this.next = next; 
 *  } 
 * }
 */

public class AddTwoNums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode temp = new ListNode();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty())
                sum += stack1.pop();
            if (!stack2.isEmpty())
                sum += stack2.pop();
            temp.val = sum % 10;
            sum /= 10;
            ListNode head = new ListNode(sum);
            head.next = temp;
            temp = head;
        }
        return temp.val == 0 ? temp.next : temp;
    }
}
