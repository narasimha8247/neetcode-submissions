class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        gp(n, new StringBuilder(), 0, 0);
        return res;
    }

    public void gp(int n, StringBuilder sb, int open, int close){
        if(sb.length()==2*n){
            res.add(sb.toString());
            return;
        }

        if(open>close){
            sb.append(")");
            gp(n, sb, open, close+1);
            sb.setLength(sb.length()-1);
        }

        if(open<n){
            sb.append("(");
            gp(n, sb, open+1, close);
            sb.setLength(sb.length()-1);
        }
    }
}
