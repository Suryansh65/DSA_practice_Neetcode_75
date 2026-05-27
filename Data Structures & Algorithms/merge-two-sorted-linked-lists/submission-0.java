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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode dummyNode = dummy;
        ListNode c1 = list1;
        ListNode c2 = list2;
        while(c1 != null && c2 != null){
            if(c1.val <= c2.val){
                dummy.next = c1;
                c1 = c1.next;
            }else{
                dummy.next = c2;
                c2 = c2.next;
            }
            dummy = dummy.next;
        }

        //Left over elements of list1
        while(c1 != null){
            dummy.next = c1;
            dummy = dummy.next;
            c1 = c1.next;
        }
        while(c2 != null){
            dummy.next = c2;
            dummy = dummy.next;
            c2 = c2.next;
        }
        return dummyNode.next;

    }
}