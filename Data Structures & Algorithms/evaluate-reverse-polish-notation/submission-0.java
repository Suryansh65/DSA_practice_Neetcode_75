class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer>st = new Stack<>();
        for(int i=0;i<n;i++){
            String ch = tokens[i];
            if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")){
                int a = st.pop();
                int b = st.pop();
                int calc = 0;
                if(ch.equals("+")){
                    calc = b + a;
                }else if(ch.equals("-")){
                    calc = (b-a);
                }else if(ch.equals("*")){
                    calc = (b * a);
                }else{
                    //division
                    calc = (b/a);
                }
                st.push(calc);
            }else{
                st.push(Integer.parseInt(ch));
            }
        }
        return st.peek();
    }
}
