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
    private ListNode getkthNode(ListNode temp, int k){
        k -= 1;
        while(temp != null && k > 0){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    private void reverse(ListNode temp){
        ListNode prev = null;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp != null){
            ListNode kthnode = getkthNode(temp,k);
            if(kthnode == null){
                if(prevNode != null)prevNode.next = temp;
                break;
            }
            ListNode nextNode = kthnode.next;
            kthnode.next = null;
            reverse(temp);
            if(temp == head){
                // 1st segment is reversed
                head = kthnode;
            }else{
                prevNode.next = kthnode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}
