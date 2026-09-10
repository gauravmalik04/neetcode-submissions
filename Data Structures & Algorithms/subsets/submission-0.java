class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        generate(0,nums,new ArrayList<>(),answer);
        return answer;
    }
    public void generate(int start , int[] arr , List<Integer> current , List<List<Integer>> answer){
        answer.add(new ArrayList<>(current));
        for(int i=start;i<arr.length;i++){
            current.add(arr[i]);
            generate(i+1,arr,current,answer);
            current.removeLast();
        }
    }
}
