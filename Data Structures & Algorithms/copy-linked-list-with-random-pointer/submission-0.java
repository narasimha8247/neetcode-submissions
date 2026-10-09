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
        Map<Node, Integer> map = new HashMap<>();
        Map<Integer, Node> deepCopyMap = new HashMap<>();

        // first just copy current and next
        Node deepCopy = new Node(0);
        Node previous = deepCopy;
        Node temp = head;
        int i=0;
        while(head!=null){
            map.put(head,i);
            int val = head.val;
            Node cur = new Node(val);
            deepCopyMap.put(i,cur);
            previous.next = cur;
            previous = cur;
            head = head.next;
            i++;
        }

        Node copy = deepCopy.next;
        while(temp!=null){
            if(temp.random!=null){
                int index = map.get(temp.random);
                copy.random = deepCopyMap.get(index);
            }
            temp = temp.next;
            copy = copy.next;
        }

        return deepCopy.next;
    }
}
