class Solution {
    public int characterReplacement(String s, int k) {
        
        Map<Character, Integer> freqMap = new HashMap<>();

        int left = 0;
        int maxFreq = 0;
        int longChar = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
            maxFreq = Math.max(maxFreq, freqMap.get(c));

            // to replace remaning char -> total-maxFreq
            int reqrpl = i-left+1 - maxFreq;
            if(reqrpl > k){
                char cc = s.charAt(left);
                freqMap.put(cc, freqMap.get(cc)-1);
                left++;
                continue;
            }
            longChar = Math.max(longChar, i-left+1);
        }
        return longChar;
    }
}
