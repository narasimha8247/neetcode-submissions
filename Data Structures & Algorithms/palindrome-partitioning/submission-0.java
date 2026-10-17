class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        pp(s, 0, new ArrayList<>());
        return res;
    }

    public void pp(String s, int start, List<String> li){
        if(start==s.length()){
            res.add(new ArrayList<>(li));
            return;
        }

        for(int i=start; i<s.length(); i++){
            String ss = s.substring(start,i+1);
            if(isPalindrome(ss)){
                li.add(ss);
                pp(s, i+1, li);
                li.remove(li.size()-1);
            }
            
        }
    }

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
