import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfProvinces {
    // Leetcode: 547. Number of Provinces
    // T(n) -> O(n*n)
    // A(n) -> O(n)
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] visited = new int[n];

        //return unionFind(M);

        int component=0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                // dfs(i,M,visited);
                bfs(i,M,visited,n);
                component++;
            }
        }
        return component;
    }
    private void dfs(int i, int[][] mat, int[] visited){
        visited[i]=1;
        for(int j = 0;j<mat.length;j++){
            if(mat[i][j]==1 && visited[j]==0){
                dfs(j,mat,visited);
            }
        }
    }

    private void bfs(int i, int[][] mat, int[] visited, int n){
        visited[i]=1;
        Queue<Integer> que = new LinkedList<>();
        que.add(i);
        while(!que.isEmpty()){
            int first = que.poll();
            for(int j=0;j<n;j++){
                if(mat[first][j]==1 && visited[j]==0){
                    visited[j]=1;
                    que.add(j);
                }
            }
        }
    }

    private int unionFind(int[][] M){
        int n = M.length;
        int[] parent = new int[n];
        for(int i =0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(M[i][j]==1){
                    union(i,j,parent);
                }
            }
        }
        Set<Integer> set= new HashSet<>();
        for(int i=0;i<n;i++){
            int x = parent(i,parent);
            set.add(x);
        }
        return set.size();
    }
    private int parent(int a,int[] parent){
        int x = parent[a];
        while(x != parent[x]){
            x = parent[x];
        }
        return x;
    }
    private void union(int a, int b, int[] parent){
        int pa = parent(a,parent);
        int pb = parent(b,parent);
        if(pa!=pb){
            parent[pa]=pb;//parent of b->a
        }
        //return pb;
    }
}
