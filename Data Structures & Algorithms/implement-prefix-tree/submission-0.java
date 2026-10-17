class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();     
    }

    public void insert(String word) {
        TrieNode cur = root;
        int i = 0;
        while(i<word.length()){
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)){
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
            i++;
        }
        cur.word = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        int i = 0;
        while(i<word.length()){
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)){
                return false;
            }
            cur = cur.children.get(c);
            i++;
        }
        return cur.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        int i = 0;
        while(i<prefix.length()){
            char c = prefix.charAt(i);
            if(!cur.children.containsKey(c)){
                return false;
            }
            cur = cur.children.get(c);
            i++;
        }
        return true;
    }

    class TrieNode{
        Map<Character, TrieNode> children;
        boolean word;
        TrieNode(){
            children = new HashMap<>();
        }
    }

}
