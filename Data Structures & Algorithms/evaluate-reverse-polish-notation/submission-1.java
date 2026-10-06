class Solution {
    public int evalRPN(String[] tokens) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<tokens.length; i++){
            switch(tokens[i]){
                case "+" -> stack.push(stack.pop()+stack.pop());
                case "-" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a-b);
                }
                case "*" -> stack.push(stack.pop()*stack.pop());
                case "/" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a/b);
                }
                default -> stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}
