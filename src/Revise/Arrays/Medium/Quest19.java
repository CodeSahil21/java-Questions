package Revise.Arrays.Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Quest19 {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4},
                      {5, 6, 7, 8},
                    {9, 10, 11, 12},
                   {13, 14, 15, 16}};

        List<Integer> ans = spiralOrder(mat);

        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }

        System.out.println();
    }
    static ArrayList<Integer> spiralOrder(int[][] arr){
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        int m = arr[0].length;
        int top = 0;
        int left = 0;
        int right = m-1;
        int bottom = n-1;
       while(top <= bottom && left <= right){
           for(int i = left ; i <= right;i++){
               list.add(arr[top][i]);
           }
           top++;
           for(int i = top;i <= bottom;i++){
               list.add(arr[i][right]);
           }
           right--;

           if(top <= bottom){
               for(int i = right; i >= left;i--){
                   list.add(arr[bottom][i]);
               }
               bottom--;
           }


           if(left <= right){
               for(int i = bottom ; i >= top;i--){
                   list.add(arr[i][left]);
               }
               left++;
           }
       }
       return list;
    }
}
