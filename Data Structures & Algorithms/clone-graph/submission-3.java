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
    public Node cloneGraph(Node node) {
        Map<Node, Node> nMap = new HashMap<>();

        return cg(node, nMap);
    }

    public Node cg(Node node, Map<Node, Node> nMap){
        if(node==null){
            return null;
        }

        if(nMap.containsKey(node)){
            return nMap.get(node);
        }

        Node copyNode = new Node(node.val);
        nMap.put(node, copyNode);

        for(Node nn : node.neighbors){
            copyNode.neighbors.add(cg(nn, nMap));
        }
        return copyNode;
    }
}