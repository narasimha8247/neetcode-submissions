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
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode previous = null;
        ListNode nextOne = null;

        while(temp!=null){
            nextOne = temp.next;
            temp.next = previous;
            previous = temp;
            temp = nextOne;
        } 

        return previous;
    }
}
