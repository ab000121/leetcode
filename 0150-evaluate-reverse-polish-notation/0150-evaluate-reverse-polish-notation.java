class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int a,b;

        for( String ch : tokens ){

            switch(ch){
                case "+": 
                     b = st.pop();
                     a = st.pop();
                    st.push(a+b);
                    break;
                
                case "-":
                     b = st.pop();
                     a = st.pop();
                    st.push(a-b);
                    break;
                
                case "/":
                     b = st.pop();
                     a = st.pop();
                    st.push(a/b);
                    break;

                case "*":
                      b= st.pop();
                      a = st.pop();
                     st.push(a*b);
                     break;
                    
                default: 
                    st.push(Integer.parseInt(String.valueOf(ch)));
                    break;

            }
        }

        return st.peek();
    }
}