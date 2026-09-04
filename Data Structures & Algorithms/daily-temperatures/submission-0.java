class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        answer[n-1] = 0;
        for(int i=0;i<n-1;i++){
            int distance = 0;
            for(int j = i+1 ; j<n;j++){
                if(temperatures[j] > temperatures[i]){
                    distance = j-i;
                    break;
                }
            }
            answer[i] = distance;
        }
        return answer;
    }
}
