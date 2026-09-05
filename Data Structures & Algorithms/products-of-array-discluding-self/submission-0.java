class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] first = new int[n];
        first[0]=nums[0];
        for(int i=1;i<n;i++){
            first[i] = first[i-1]*nums[i];
        }
        int[] second = new int[n];
        second[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            second[i] = second[i+1]*nums[i];
        }
        int[] answer = new int[n];
        answer[0] = second[1];
        answer[n-1] = first[n-2];
        for(int i=1;i<=n-2;i++){
            answer[i] = first[i-1]*second[i+1];
        }
        return answer;
    }
}  
