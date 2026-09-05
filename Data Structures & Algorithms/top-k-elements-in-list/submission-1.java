class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x: nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        for(int key : map.keySet()){
            int[] set = new int[]{key,map.get(key)};
            pq.offer(set);
        }
        while(pq.size() > k) pq.poll();
        int[] answer = new int[k];
        for(int i = 0;i<k;i++){
            answer[i] = pq.poll()[0];
        }
        return answer;
    }
}
