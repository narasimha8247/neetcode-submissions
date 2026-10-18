class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        int i=0;
        while(i<word.length()){
            char c = word.charAt(i);
            cur = cur.children.computeIfAbsent(c, k -> new TrieNode());
            i++;
        }
        cur.word = true;
    }

    public boolean search(String word) {
        return ss(word, 0, root);
    }

    public boolean ss(String word, int start, TrieNode tn){
        if(start==word.length()){
            return tn.word;
        }

        char c = word.charAt(start);
        if(c!='.'){
            // search only for this character
            tn = tn.children.get(c);
            if(tn==null){
                return false;
            }else{
                return ss(word, start+1, tn);
            }
            
        }else{
            boolean res = false;
            // search all the characters as valid
            Map<Character, TrieNode> map = tn.children;
            for(TrieNode tns : map.values()){
                res = res || ss(word, start+1, tns);
            }
            return res;
        }
    }

    class TrieNode{
        Map<Character, TrieNode> children;
        boolean word;
        TrieNode(){
            children = new HashMap<>();
        }
    }
}
