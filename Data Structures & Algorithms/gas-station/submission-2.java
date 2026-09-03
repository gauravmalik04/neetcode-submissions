class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        for(int g : gas) gasSum+=g;
        for(int c : cost) costSum += c;
        if(gasSum < costSum) return -1;
        int tank = 0;
        int answer = 0;
        int n = gas.length;
        for(int i=0;i<n;i++){
            tank+=gas[i] - cost[i];
            if(tank < 0){
                tank = 0;
                answer = i+1;
            }
        }
        return answer;
    }
}
