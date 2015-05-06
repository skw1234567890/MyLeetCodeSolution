/*
 You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //special case: at least one of two lists is empty
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        int tmpValue = l1.val + l2.val;
        //carry 1 or 0
        int addOne = tmpValue/10;
        ListNode head = new ListNode(tmpValue%10);
        ListNode p = head;
        
        //while loop
        while((l1.next != null) && (l2.next != null)){
            l1 = l1.next;
            l2 = l2.next;
            int tmpVal = l1.val + l2.val + addOne;
            addOne = tmpVal/10;
            p.next = new ListNode(tmpVal%10);
            p = p.next;
        }
        while(l1.next != null){
            l1 = l1.next;
            int tmpVal = l1.val + addOne;
            addOne = tmpVal/10;
            p.next = new ListNode(tmpVal%10);
            p = p.next;
        }
        while(l2.next != null){
            l2 = l2.next;
            int tmpVal = l2.val + addOne;
            addOne = tmpVal/10;
            p.next = new ListNode(tmpVal%10);
            p = p.next;
        }
        
        //if the carry on exists at end, add 1
        if(addOne == 1){
            p.next = new ListNode(1);
        }
        return head;
    }
}