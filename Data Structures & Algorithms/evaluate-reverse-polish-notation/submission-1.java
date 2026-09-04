class Solution {
    public boolean isOperator(String str){
        return (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }
    public int evaluate(int a , int b , String operator){
        switch(operator){
            case "+" : return a+b;
            case "-" : return a-b;
            case "/" : return a/b;
            case "*" : return a*b;
            default : return -1;
        }
    }
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<String> st = new Stack<>();
        for(int i = 0 ;i < n;i++){
            String str = tokens[i];
            if(isOperator(str)){
                int b = Integer.parseInt(st.pop());
                int a = Integer.parseInt(st.pop());

                int result = evaluate(a,b,str);
                st.push(Integer.toString(result));
            }else{
                int number = Integer.parseInt(str);
                st.push(str);
            }
        }
        return Integer.parseInt(st.peek());
    }
}
