class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs.size(); i++){
            sb.append(strs.get(i).length())
                .append("#")
                .append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        
        List<String> li = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            
            int hashIndex = str.indexOf("#",i);
            int length = Integer.parseInt(str.substring(i,hashIndex));

            i = hashIndex+1;
            li.add(str.substring(i,i+length));
            i = i+length;
        }
        return li;
    }

    
}
