package Revise.Graphs.ShortestPath;

import java.util.Arrays;
import java.util.PriorityQueue;

class Tuple1{
    int distance;
    int row;
    int col;
    public Tuple1(int distance,int row, int col){
        this.row = row;
        this.distance = distance;
        this.col = col;
    }
}
public class Quest9 {
    public static void main(String[] args) {

        int[][] heights={{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};


        int ans =  minimumEffortPath(heights);

        System.out.print(ans);
        System.out.println();
    }
    public static int minimumEffortPath(int[][] heights){
        PriorityQueue<Tuple1> pq = new PriorityQueue<>((x,y)->x.distance- y.distance);
        int n = heights.length;;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int)(1e9);
            }
        }
        dist[0][0] = 0;
        pq.add(new Tuple1(0,0,0));
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol =  {0,1,0,-1};
        while(!pq.isEmpty()){
            Tuple1 it = pq.peek();
            pq.remove();
            int diff = it.distance;
            int r = it.row;
            int c  = it.col;
            if(r == n-1 && c == m-1){
                return diff;
            }
            for(int i =0 ; i < 4;i++){
                int newr = r + delrow[i];
                int newc = c + delcol[i];
                if(newr >= 0 && newr < n && newc >=0 && newc < m){
                    int newEffort = Math.max(Math.abs(heights[r][c] - heights[newr][newc]),diff);
                    if(newEffort < dist[newr][newc]){
                        dist[newr][newc] = newEffort;
                        pq.add(new Tuple1(newEffort,newr,newc));
                    }
                }
            }
        }
     return 0;
    }
}
