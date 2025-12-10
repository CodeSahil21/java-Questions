package Topics.Arrays.Hard;
//https://leetcode.com/problems/pascals-triangle/description/
//pascals triangle
import java.util.*;
public class Quest1 {
    public static void main(String[] args) {
        List<List<Integer>> ans = generate(5);
        System.out.println(ans);
    }
 //variation 3: generate entire pascal triangle
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
/*
variation 1:n!/r!*(n-r)!
We can optimize this calculation by the following observation.
Assume, given r = 7, c = 4.
Now, n = r-1 = 7-1 = 6 and r = c-1 = 4-1 = 3
Let’s calculate 6C3 = 6! / (3! *(6-3)!) = (6*5*4*3*2*1) / ((3*2*1)*(3*2*1))
This will boil down to (6*5*4) / (3*2*1)
So, nCr = (n*(n-1)*(n-2)*.....*(n-r+1)) / (r*(r-1)*(r-2)*....1)

 public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static int pascalTriangle(int r, int c) {
        int element = (int) nCr(r - 1, c - 1);
        return element;
    }

    public static void main(String[] args) {
        int r = 5; // row number
        int c = 3; // col number
        int element = pascalTriangle(r, c);
        System.out.println("The element at position (r,c) is: " + element);
    }

    variation 2:generating col of pascal triangle
    Current element = prevElement * (rowNumber - colIndex) / colIndex

    static void pascalTriangle(int n) {
        long ans = 1;
        System.out.print(ans + " "); // printing 1st element

        // Printing the rest of the part:
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            System.out.print(ans + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5;
        pascalTriangle(n);
    }
 */