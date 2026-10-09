/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head==null){
            return null;
        }

        // create copy and add next to it
        Node copy = head;
        while(copy!=null){
            Node newNode = new Node(copy.val);
            Node nextNode = copy.next;
            copy.next = newNode;
            newNode.next = nextNode;
            copy = nextNode;
        }

        // now update random
        copy = head;
        Node temp = head;
        while(copy!=null){
            if(copy.random!=null){
                copy.next.random = copy.random.next;
            }else{
                copy.next.random = null;
            }
            copy = copy.next.next; 
        }

        // remove original ones
        
        copy = head.next;
        Node orig = head;
        Node copyHead = copy;
        while(orig!=null){
            orig.next = orig.next.next;
            if(copy.next!=null)
                copy.next = copy.next.next;
            orig = orig.next;
            copy = copy.next;
        }

        return copyHead;
    }
}
