class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        answer[n-1] = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i>=0;i--){
            while(st.size() > 0 && temperatures[st.peek()] <= temperatures[i]) st.pop();
            if(st.size() > 0) answer[i] = st.peek() - i;
            else answer[i] = 0;
            st.push(i);
        }
        return answer;
    }
}
