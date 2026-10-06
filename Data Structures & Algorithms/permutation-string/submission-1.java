class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()){
            return false;
        }

        Map<Character, Integer> s1Map = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            s1Map.put(c, s1Map.getOrDefault(c,0)+1);
        }

        Map<Character, Integer> s2Map = new HashMap<>();
        int left = 0;
        for(int i=0; i<s2.length(); i++){
            char c = s2.charAt(i);
            s2Map.put(c, s2Map.getOrDefault(c,0)+1);
            if(i-left+1 == s1.length()){
                if(s1Map.equals(s2Map)){
                    return true;
                }else{
                    char cc = s2.charAt(left);
                    if(s2Map.get(cc)==1){
                        s2Map.remove(cc);
                    }else{
                        s2Map.put(cc,s2Map.get(cc)-1);
                    }
                    left++;
                }
            }

        }

        return false;


    }
}
