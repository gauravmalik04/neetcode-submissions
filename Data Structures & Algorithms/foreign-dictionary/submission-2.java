class Solution {
    public List<Integer> topology(List<List<Integer>> adj,Set<Character> chars){
        int V = adj.size();
        int[] indegree = new int[V];
        for(int i=0;i<V;i++){
            for(int next : adj.get(i)){
                indegree[next]++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0 && chars.contains((char)(i+'a'))) q.offer(i);
        }
        while(q.size()>0){
            int node = q.poll();
            order.add(node);
            for(int next : adj.get(node)){
                indegree[next]--;
                if(indegree[next]==0) q.offer(next);
            }
        }
        return order;
    }
    public String foreignDictionary(String[] words) {
      int n = words.length;
      Set<Character> chars = new HashSet<>();
      for(String word : words){
        for(int i=0;i<word.length();i++){
            chars.add(word.charAt(i));
        }
      }
      List<List<Integer>> adj = new ArrayList<>();
      for(int i=0;i<26;i++) adj.add(new ArrayList<>());
      for(int i=0;i<n-1;i++){
        String word1 = words[i];
        String word2 = words[i+1];
        if(word1.length() > word2.length() && word1.startsWith(word2)) return "";
        int len = Math.min(word1.length(),word2.length());
        for(int j=0;j<len;j++){
            char ch1 = word1.charAt(j);
            char ch2 = word2.charAt(j);
            if(ch1!=ch2){
                adj.get(ch1-'a').add(ch2-'a');
                break;
            }
        }
      }
      List<Integer> topo = topology(adj,chars);
      if(topo.size() != chars.size()) return "";
      StringBuilder sb = new StringBuilder("");
      for(int it : topo){
        sb.append((char)(it + (int)'a'));
      }
      return sb.toString();
    }
}
