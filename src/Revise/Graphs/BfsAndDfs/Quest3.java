package Revise.Graphs.BfsAndDfs;

public class Quest3 {
    public static void main(String[] args)
    {
        int[][] image =  {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        // sr = 1, sc = 1, newColor = 2
        int[][] ans = floodFill(image, 1, 1, 2);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }
    static int[][] floodFill(int[][] image,int sr ,int sc,int newcolor){
        int inicolor = image[sr][sc];
        int[][] ans = image;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        dfs(image,ans,inicolor,newcolor,sr,sc,delrow,delcol);
        return ans;
    }
    private static void dfs(int[][] image,int[][] ans,int inicolor,int newcolor,int row,int col,int[] delrow,int[] delcol){
        ans[row][col] = newcolor;
        int n = image.length;
        int m = image[0].length;
        for(int i = 0 ; i < 4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >=0 && nrow < n && ncol >=0 && ncol < m && image[nrow][ncol] == inicolor && ans[nrow][ncol] != newcolor){
                dfs(image,ans,inicolor,newcolor,nrow,ncol,delrow,delcol);
            }
        }
    }
}
