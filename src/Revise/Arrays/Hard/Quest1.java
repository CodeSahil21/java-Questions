package Revise.Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class Quest1 {
    public static void main(String[] args) {
        int r = 5; // row number
        int c = 3; // col number
        int element = pascalTriangle(r, c);
        System.out.println("The element at position (r,c) is: " + element);
        pascalTriangle(3);
    }
//pascal triangle variation one via Ncr
    static int pascalTriangle(int r, int c){
        return (int) Ncr(r-1,c-1);
    }
    static long Ncr(int n , int r){
        long res = 1;
        for(int i =0 ; i < r; i++){
            res = res * (n - i);
            res = res /(i+1);
        }
        return res;
    }
 //pascal triangle variation generating row of pascal triangle
 static void pascalTriangle(int n){
     long ans = 1;
     System.out.print(ans + " "); // printing 1st element
     for(int i = 1 ; i < n ; i++){
         ans = ans * (n-i);
         ans = ans / i;
         System.out.print(ans + " ");
     }
     System.out.println();
 }
 //variation3 :generate entire pascal triangle
 public static  List<List<Integer>> generate(int numRows) {
     List<List<Integer>> pascal = new ArrayList<>();
     for (int col = 1; col <=numRows ; col++) {
         pascal.add(generateRow(col));
     }
     return pascal;
 }

    public static List<Integer> generateRow(int row){
        long ans = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int col = 1; col <row ; col++) {
            ans = ans*(row-col);
            ans = ans /col;
            list.add((int)ans);
        }
        return list;
    }
}
