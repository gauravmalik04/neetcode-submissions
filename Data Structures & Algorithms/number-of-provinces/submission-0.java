class Solution {
    public void bfs(int source, int[][] adj , int[] visited){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(source);
        while(!q.isEmpty()){
            Integer node = q.poll();
            for(int j=0;j<adj[node].length;j++){
                if(adj[node][j]==1 && visited[j]==0){
                    visited[j] = 1;
                    q.offer(j);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        int[] visited = new int[V];
        int count = 0;
        for(int i = 0;i<V;i++){
            if(visited[i]==0){
                visited[i] = 1;
                bfs(i,isConnected,visited);
                count++;
            }
        }
        return count;
    }
}