class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        int right = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            if(c=='(' || c=='{' || c=='['){
                st.push(c);
            }else{
                if(st.isEmpty()){
                    return false;
                } 
                char top = st.pop();
                if(c==')' && top!='('){
                    return false;
                }
                if(c==']' && top!='['){
                    return false;
                }
                if(c=='}' && top!='{'){
                    return false;
                }
            }

            right++;
        }

        return st.isEmpty();
    }
}
