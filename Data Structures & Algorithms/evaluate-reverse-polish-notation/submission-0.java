class Solution {
    public int evalRPN(String[] tokens) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        int out = 0;
        for(int i=0; i<tokens.length; i++){

            if(tokens[i].equals("+")){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(first+second);
            }else if(tokens[i].equals("-")){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second-first);
            }else if(tokens[i].equals("*")){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(first*second);
            }else if(tokens[i].equals("/")){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second/first);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}
