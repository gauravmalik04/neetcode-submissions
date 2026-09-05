class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        // int[] ans = new int[2];
        for(int i=0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(nums[i]+nums[j] == target){
                    int[] answer = {i,j};
                    return answer;
                }
            }
        }
        return new int[2];
    }
}
