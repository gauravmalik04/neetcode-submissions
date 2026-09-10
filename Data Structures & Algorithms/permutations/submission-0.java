class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        generate(nums,new ArrayList<>(),answer,visited);
        return answer;
    }
    public void generate(int[] arr, List<Integer> current , List<List<Integer>> answer, boolean[] visited){
        if(current.size() == arr.length){
            answer.add(new ArrayList<>(current));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(visited[i]==true) continue;
            current.add(arr[i]);
            visited[i] = true;
            generate(arr,current,answer,visited);
            current.removeLast();
            visited[i] = false;
        }
    }
}
