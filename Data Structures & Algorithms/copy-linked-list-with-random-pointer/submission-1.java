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
        
        // make a list of pointers
        Map<Node, Node> map = new HashMap<>();
        Map<Integer, Node> deepCopyMap = new HashMap<>();

        // first just copy current and next
        Node deepCopy = new Node(0);
        Node previous = deepCopy;
        Node temp = head;
        
        while(head!=null){
            
            int val = head.val;
            Node cur = new Node(val);
            map.put(head,cur);
            previous.next = cur;
            previous = cur;
            head = head.next;
            
        }

        Node copy = deepCopy.next;
        while(temp!=null){
            if(temp.random!=null){
                copy.random = map.get(temp.random);
            }
            temp = temp.next;
            copy = copy.next;
        }

        return deepCopy.next;
    }
}
