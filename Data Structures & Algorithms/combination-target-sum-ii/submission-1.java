class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        generate(0,candidates,target,new ArrayList<>(),answer);
        return answer;
    }
    public void generate(int start, int[] arr, int target, List<Integer> current,List<List<Integer>> answer){
        if(target==0){
            answer.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<arr.length;i++){
            if(i>start && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
            current.add(arr[i]);
            generate(i+1,arr,target-arr[i],current,answer);
            current.removeLast();
        }
    }
}
