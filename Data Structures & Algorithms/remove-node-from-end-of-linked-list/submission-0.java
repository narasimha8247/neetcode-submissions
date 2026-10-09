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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = head;
        while(n>1){
            temp = temp.next;
            n--;
        }

        ListNode removable = new ListNode(0);
        ListNode ret = removable;
        removable.next = head;
        while(temp.next!=null){
            temp = temp.next;
            removable = removable.next;
        }

        removable.next = removable.next.next;
        return ret.next;
    }
}
