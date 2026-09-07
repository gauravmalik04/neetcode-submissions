class Solution {
    public void findArea(int row , int col , int[][] grid , boolean[][] visited,int[] answer){
        Queue<List<Integer>> q = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;
        q.offer(new ArrayList<>(List.of(row,col)));
        int area = 1;
        while(!q.isEmpty()){
            List<Integer> node = q.poll();
            int r = node.get(0);
            int c = node.get(1);
            if(c>0 && grid[r][c-1]==1 && visited[r][c-1]==false){
                q.offer(new ArrayList<>(List.of(r,c-1)));
                visited[r][c-1]=true;
                area++;
            }
            if(c<m-1 && grid[r][c+1]==1 && visited[r][c+1]==false){
                q.offer(new ArrayList<>(List.of(r,c+1)));
                visited[r][c+1]= true;
                area++;
            }
            if(r>0 && grid[r-1][c]==1 && visited[r-1][c]==false){
                q.offer(new ArrayList<>(List.of(r-1,c)));
                visited[r-1][c] = true;
                area++;
            }
            if(r<n-1 && grid[r+1][c] == 1 && visited[r+1][c]==false){
                q.offer(new ArrayList<>(List.of(r+1,c)));
                area++;
                visited[r+1][c] = true;
            }
        }
        answer[0] = Math.max(answer[0],area);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] answer = new int[1];
        answer[0] = 0;
        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    visited[i][j] = true;
                    findArea(i,j,grid,visited,answer);
                }
            }
        }
        return answer[0];
    }
}
