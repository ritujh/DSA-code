/**
Rotting Oranges

In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 
HINT-> GRAPH & DFS
count num of rotton oranges and total
check diff in last
 
 */
 class Solution {
    class Pair{
        int i;
        int  j;
        public Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int time = 0;
        int total = 0;
        int rotton = 0;
        Queue<Pair> que = new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==2 || grid[i][j]==1){
                    total++;
                }
                if(grid[i][j]==2){
                    rotton++;
                    que.add(new Pair(i,j));
                }
            }
        }
        if(total==0)
            return 0;
        //BFS
        while(que.isEmpty()==false){
            int size = que.size();
            if(total==rotton)return time;
            for(int k=0;k<size;k++){
                Pair p = que.poll();
                int i = p.i;
                int j = p.j;
                if(isSafe(i+1,j,r,c)&& grid[i+1][j]==1){
                    que.add(new Pair(i+1,j));
                    grid[i+1][j]=2;
                    rotton++;
                }
                if(isSafe(i-1,j,r,c)&& grid[i-1][j]==1){
                   que.add(new Pair(i-1,j));
                    grid[i-1][j]=2;
                    rotton++;
                }
                if(isSafe(i,j+1,r,c)&& grid[i][j+1]==1){
                   que.add(new Pair(i,j+1));
                    grid[i][j+1]=2;
                    rotton++;
                }
                if(isSafe(i,j-1,r,c)&& grid[i][j-1]==1){
                   que.add(new Pair(i,j-1));
                    grid[i][j-1]=2;
                    rotton++;
                }
            }
            time++;
        }
        return -1;
    }
    public boolean isSafe(int i,int j,int r, int c){
        if(i>=0 && i<r && j>=0 && j<c)
            return true;
        return false;
    }
}
