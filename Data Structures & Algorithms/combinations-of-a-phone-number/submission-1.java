class Solution {
    List<String> resList = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return resList;
        }
        Map<Character, String> map = Map.of(
            '2',"abc",
            '3',"def",
            '4',"ghi",
            '5',"jkl",
            '6',"mno",
            '7',"pqrs",
            '8',"tuv",
            '9',"wxyz"
        );
        List<String> ss = new ArrayList<>();
        for(int i=0; i<digits.length(); i++){
            ss.add(map.get(digits.charAt(i)));
        }

        lcb(ss, 0, new StringBuilder());
        return resList;
        
    }

    public void lcb(List<String> ss, int start, StringBuilder res){
        if(res.length()==ss.size()){
            resList.add(res.toString());
            return;
        }
        String curString = ss.get(start);
        for(int i=0; i<curString.length(); i++){
            res.append(curString.charAt(i));
            lcb(ss, start+1, res);
            res.setLength(res.length()-1);
        }
    }
}
