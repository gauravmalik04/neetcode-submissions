class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    visited[i][j] = true;
                    islands++;
                    bfs(i,j,grid,visited);
                }
            }
        }
        return islands;
    }
    public void bfs(int row, int col, char[][] grid , boolean[][] visited){
        int n = grid.length;
        int m = grid[0].length;
        Queue<List<Integer>> q = new ArrayDeque<>();
        List<Integer> source = new ArrayList<>();
        source.add(row);
        source.add(col);
        q.offer(source);
        while(!q.isEmpty()){
            List<Integer> node = q.poll();
            int r = node.get(0);
            int c = node.get(1);
            boolean left = c>=1 && grid[r][c-1]=='1'?true:false;
            boolean right = c<m-1 && grid[r][c+1]=='1'?true:false;
            boolean up = r>=1 && grid[r-1][c]=='1'?true:false;
            boolean down = r<n-1 && grid[r+1][c]=='1'?true:false;
            // boolean upperleft = r>=1&&c>=1&& grid[r-1][c-1]=='1'?true:false;
            // boolean upperright = r>=1&&c<n-1 && grid[r-1][c+1]=='1'?true:false;
            // boolean lowerLeft = r<n-1&&c>=1 && grid[r+1][c-1]=='1'?true:false;
            // boolean lowerRight = r<n-1&&c<n-1 && grid[r+1][c+1]=='1'?true:false;
            if(left && visited[r][c-1]==false){
                q.offer(new ArrayList<>(List.of(r,c-1)));
                visited[r][c-1] = true;
            }
            if(right && visited[r][c+1]==false){
                q.offer(new ArrayList<>(List.of(r,c+1)));
                visited[r][c+1]=true;
            }
            if(up && visited[r-1][c]==false){
                q.offer(new ArrayList<>(List.of(r-1,c)));
                visited[r-1][c] = true;
            }
            if(down && visited[r+1][c]==false){
                q.offer(new ArrayList<>(List.of(r+1,c)));
                visited[r+1][c] = true;
            }
            // if(upperleft && visited[r-1][c-1]==false){
            //     q.offer(new ArrayList<>(List.of(r-1,c-1)));
            //     visited[r-1][c-1]=true;
            // }
            // if(upperright && visited[r-1][c+1]==false){
            //     q.offer(new ArrayList<>(List.of(r-1,c+1)));
            //     visited[r-1][c+1]=true;
            // }
            // if(lowerLeft && visited[r+1][c-1]==false){
            //     q.offer(new ArrayList<>(List.of(r+1,c-1)));
            //     visited[r+1][c-1]=true;
            // }
            // if(lowerRight && visited[r+1][c+1]==false){
            //     q.offer(new ArrayList<>(List.of(r+1,c+1)));
            //     visited[r+1][c+1]=true;
            // }
        }
    }
}
