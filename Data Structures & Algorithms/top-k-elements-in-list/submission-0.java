class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : nums){
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }else map.put(x,1);
        }
        int[][] freqs = new int[map.size()][2];
        int j = 0;
        for(int key: map.keySet()){
            freqs[j][0] = key;
            freqs[j][1] = map.get(key);
            j++;
        }
        Arrays.sort(freqs, (a,b)->Integer.compare(b[1],a[1]));
        int[] answer = new int[k];
        for(int i = 0 ;i < k;i++){
            answer[i] = freqs[i][0];
        }
        return answer;
    }
}
