class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            int c = s.charAt(i);
            if(isAlphaNumeric(c)){
                // convert caps to small
                if(c>=65 && c<=90){
                    c = c-65+97;
                }
                char ch = (char) c;
                sb.append(ch);
            }
        }
        s = sb.toString();
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

    public boolean isAlphaNumeric(int c){

        if((c >=65 && c <=90) || 
            (c >=97 && c<=122) ||
            (c >= 48 && c<=57)){
                return true;
        }
        return false;
    }
}
