/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> nMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        return cg(node);
    }

    public Node cg(Node node){
        if(node==null){
            return null;
        }
        if(nMap.containsKey(node.val)){
            return nMap.get(node.val);
        }
        Node copyNode = new Node(node.val);
        nMap.put(node.val, copyNode);
        List<Node> nbrs = node.neighbors;
        for(int i=0; i<nbrs.size(); i++){
            
            copyNode.neighbors.add(cg(nbrs.get(i)));
            
        }
        return copyNode;
    }
}