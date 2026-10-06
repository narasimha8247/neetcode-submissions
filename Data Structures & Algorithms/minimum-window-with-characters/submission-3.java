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
        int have = 0;
        int need = tMap.size();
        for(int i=0; i<s.length(); i++){
            char cc = s.charAt(i);
            sMap.put(cc, sMap.getOrDefault(cc,0)+1);
            
            if(tMap.containsKey(cc) && sMap.get(cc).equals(tMap.get(cc))){
                have++;
            }

            while(have == need){
                
                if(min > (i-left+1)){
                    min = i-left+1;
                    out[0] = left;
                    out[1] = i+1;
                }
                
                char cr = s.charAt(left);

                sMap.put(cr, sMap.get(cr)-1);
                if(tMap.containsKey(cr) && sMap.get(cr)<tMap.get(cr)){
                    have--;
                }
                if(sMap.get(cr)==0){
                    sMap.remove(cr);
                }
                left++;
            }
        }
        return s.substring(out[0],out[1]);
    }

    
}
