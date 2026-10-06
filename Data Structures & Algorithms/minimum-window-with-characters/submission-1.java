class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c,0)+1);
        }

        int left = 0;
        int min = Integer.MAX_VALUE;
        int[] out = new int[]{0,0};
        Map<Character, Integer> sMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char cc = s.charAt(i);
            sMap.put(cc, sMap.getOrDefault(cc,0)+1);
            
            while(isValid(tMap,sMap)){
                
                if(min > (i-left+1)){
                    min = i-left+1;
                    out[0] = left;
                    out[1] = i+1;
                }
                
                char cr = s.charAt(left);
                if(sMap.get(cr)==1){
                    sMap.remove(cr);
                }else{
                    sMap.put(cr, sMap.get(cr)-1);
                }
                left++;
            }
        }
        return s.substring(out[0],out[1]);
    }

    public boolean isValid(Map<Character, Integer> t, Map<Character,Integer> s2){

        for(Character key : t.keySet()){
            if(!s2.containsKey(key)){
                return false;
            }
            if(s2.get(key)<t.get(key)){
                return false;
            }
        }

        return true;
    }
}
