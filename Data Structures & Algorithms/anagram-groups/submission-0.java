class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> retList = new ArrayList<>();
        Set<Integer> indexProcessed = new HashSet<>();
        for(int i=0; i<strs.length; i++){
            if(!indexProcessed.add(i)){
                continue;
            }
            List<String> li = new ArrayList<>();
            li.add(strs[i]);
            for(int j=i+1; j<strs.length; j++){
                if(isAnagram(strs[i], strs[j])){
                    indexProcessed.add(j);
                    li.add(strs[j]);
                }
            }
            retList.add(li);
        } 
        return retList;

    }

    public boolean isAnagram(String s1, String s2){

        if(s1.length() != s2.length())
            return false;
        
        int[] charCount = new int[26];
        
        for(int i=0; i<s1.length(); i++){
            charCount[s1.charAt(i)-'a']++;
            charCount[s2.charAt(i)-'a']--;
        }

        for(int i=0; i<26; i++){
            if(charCount[i]!=0)
                return false;
        }

        return true;

    }
}
