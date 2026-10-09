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
        
        // find the middle one and then do reversal, will be easy
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is mid point
        // will reverse from slow onwards
        ListNode previous = null;
        ListNode cur = slow.next;
        slow.next=null;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = previous;
            previous = cur;
            cur = next;
        }
        // previous : 6->5->4
        boolean odd = true;
        ListNode start = new ListNode(0);
        ListNode temp = start;
        while(head!=null && previous!=null){
            if(odd){
                odd=false;
                start.next = head;
                head=head.next;
            }else{
                odd=true;
                start.next=previous;
                previous=previous.next;
            }
            start = start.next;
        }
        start.next = head!=null?head : previous; 
        head = temp.next;

    }
}
