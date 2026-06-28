class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n , 0 , 0 , new StringBuilder() , res);

        return res;
    }

    public void backtrack(int n , int open , int close , StringBuilder curr , List<String> res){
        if(curr.length() == 2*n){
            res.add(curr.toString());
            return;
        }

        if(open < n){
            curr.append("(");
            
            backtrack( n , open + 1 , close , curr , res);
            curr.deleteCharAt(curr.length() -1);
        }

        if(close < open){
            curr.append(")");
            
            backtrack(n , open , close + 1 , curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}