class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> retList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            
            String countStr = charCount(strs[i]);
            map.computeIfAbsent(countStr, k -> new ArrayList<>()).add(strs[i]);

        }
        for(List<String> li : map.values()){
            retList.add(li);
        } 
        return retList;

    }

    public String charCount(String s1){
        int[] charCount = new int[26];
        
        for(int i=0; i<s1.length(); i++){
            charCount[s1.charAt(i)-'a']++;
        }
        StringBuilder countStr = new StringBuilder("");
        for(int i=0; i<26; i++){
            char c = (char)('a' + i);
            countStr.append(c);
            countStr.append(charCount[i]+ ",");
        }
        return countStr.toString();
    }
}
