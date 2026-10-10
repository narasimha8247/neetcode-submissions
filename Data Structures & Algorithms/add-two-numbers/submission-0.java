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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(l1!=null && l2!=null){
            int addition = l1.val+l2.val+carry;
            int ones = addition%10;
            carry = addition/10;
            ListNode li = new ListNode(ones);
            result.next = li;
            result = result.next;
            l1=l1.next;
            l2=l2.next;
        }

        while(l1!=null){
            int add = l1.val+carry;
            int ones = add%10;
            carry = add/10;
            ListNode li = new ListNode(ones);
            result.next = li;
            result = result.next;
            l1=l1.next;
        }

        while(l2!=null){
            int add = l2.val+carry;
            int ones = add%10;
            carry = add/10;
            ListNode li = new ListNode(ones);
            result.next = li;
            result = result.next;
            l2=l2.next;
        }

        if(carry!=0){
            ListNode li = new ListNode(carry);
            result.next = li;
        }
        return temp.next;
    }
}
