class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> map = new LinkedHashMap<>();
        int max = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                Set<Character> keys = new LinkedHashSet<>(map.keySet());
                for(Character cInMap : keys){
                    if(cInMap == c){
                        map.remove(cInMap);
                        break;
                    }
                    map.remove(cInMap);
                }
            }
            map.put(c,i);
            max = Math.max(max, map.size());

        }
        return max;
    }
}
