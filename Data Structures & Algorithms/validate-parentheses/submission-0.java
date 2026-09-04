class Solution {
    public boolean isOpening(char ch){
        return (ch=='(' || ch=='[' || ch=='{');
    }
    public boolean isClosing(char ch){
        return (ch==')' || ch==']' || ch=='}');
    }
    public boolean isPair(char open, char close){
        return (
            (open=='(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}')
        );
    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(isOpening(ch)) st.push(ch);
            else if(isClosing(ch)){
                if(st.size()==0) return false;
                if(isPair(st.peek(),ch)) st.pop();
                else return false;
            }
        }
        return st.size()==0;
    }
}
