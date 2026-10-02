class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            
            String countStr = charCount(strs[i]);
            map.computeIfAbsent(countStr, k -> new ArrayList<>()).add(strs[i]);

        }
         
        return new ArrayList<>(map.values());

    }

    public String charCount(String s1){
        int[] charCount = new int[26];
        
        for(int i=0; i<s1.length(); i++){
            charCount[s1.charAt(i)-'a']++;
        }
        StringBuilder countStr = new StringBuilder("");
        for(int i=0; i<26; i++){
            countStr.append(charCount[i]).append("#");
        }
        return countStr.toString();
    }
}
