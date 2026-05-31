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

class Solution {
    public void reorderList(ListNode head) {
        //Finding the middle
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;

        //Reverse the second half
        ListNode prev = null;
        ListNode curr = secondHalf;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //prev is our first node 
        ListNode h1 = head;
        ListNode h2 = prev;
        while(h1 != null && h2 != null){
            ListNode next1 = h1.next;
            ListNode next2 = h2.next;
            h1.next = h2;
            h2.next = next1;
            h1 = next1;
            h2 = next2;
        }

    }
}
