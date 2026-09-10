class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        generate(0,nums,target,new ArrayList<>(),answer);
        return answer;
    }
    public void generate(int i , int[] arr,int target, List<Integer> current , List<List<Integer>> answer){
        if(target<0) return;
        if(target == 0){
            answer.add(new ArrayList<>(current));
            return;
        }
        if(i>=arr.length) return;
        current.add(arr[i]);
        generate(i,arr,target-arr[i],current,answer);
        current.removeLast();
        generate(i+1,arr,target,current,answer);
    }
}
