class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        int right = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            boolean dontadd = false;
            if(!st.isEmpty()){
                char top = st.peek();
                if(c=='}' && top=='{'){
                    st.pop();
                    dontadd = true;
                }
                if(c==']' && top == '['){
                    st.pop();
                    dontadd = true;
                }
                if(c==')' && top == '('){
                    st.pop();
                    dontadd = true;
                }
            }
            if(!dontadd){
                st.push(c);
            }
            right++;
        }

        return st.isEmpty();
    }
}
