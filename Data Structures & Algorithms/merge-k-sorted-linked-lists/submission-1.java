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
class Pair{
    int val;
    ListNode node;
    Pair(int val,ListNode node){
        this.val = val;
        this.node = node;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)return null;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.val,b.val));
        // Step-1 Creating and Filling of PQ
        for(ListNode head: lists){
            pq.offer(new Pair(head.val,head));
        }
        //Creating Dummy Node and iterate over PQ
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!pq.isEmpty()){
            Pair p = pq.peek();
            int val = p.val;
            ListNode n = p.node;
            temp.next = n;
            temp = temp.next;
            pq.poll();
            if(n.next != null){
                pq.offer(new Pair(n.next.val,n.next));
            }
        }
        return dummy.next;

    }
}
