class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> charSet = new HashSet<>();
        int max = 0;
        int left = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            while(charSet.contains(c)){
                charSet.remove(s.charAt(left++));
            }
            charSet.add(c);
            max = Math.max(max, charSet.size());

        }
        return max;
    }
}
