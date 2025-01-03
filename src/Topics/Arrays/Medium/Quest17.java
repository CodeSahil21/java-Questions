package Topics.Arrays.Medium;
//https://leetcode.com/problems/set-matrix-zeroes/description/
//set-matrix-zeroes
public class Quest17 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };
        setZeroes(matrix);
        // Printing the modified matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static  void setZeroes(int[][] matrix) {
     int[] row = new int[matrix.length];
     int[] col  = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }

    }

    /*
    public static int[][] zeroMatrix(int[][] matrix) {
    int n = matrix.length; // Number of rows
    int m = matrix[0].length; // Number of columns
    int col0 = 1;
     // Step 1: Traverse the matrix and mark the 1st row & column accordingly
      for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
      if (matrix[i][j] == 0) {
      // Mark the i-th row
      matrix[i][0] = 0;
      // Mark the j-th column i
      f (j != 0){
       matrix[0][j] = 0;
        }else{
         col0 = 0;
         }
        }
        }
         }
          // Step 2: Mark with 0 from (1,1) to (n-1, m-1)
          for (int i = 1; i < n; i++) {
          for (int j = 1; j < m; j++) {
          if (matrix[i][j] != 0) {
          // Check for col & row
           if (matrix[i][0] == 0 || matrix[0][j] == 0) {
            matrix[i][j] = 0;
             }
              }
               }
                }
                // Step 3: Finally mark the 1st column and then the 1st row
                if (matrix[0][0] == 0) {
                for (int j = 0; j < m; j++) {
                 matrix[0][j] = 0;
                 }
                 } if (col0 == 0) {
                  for (int i = 0; i < n; i++) {
                   matrix[i][0] = 0;
                   }
                    }
                     return matrix;
                     }
     */
}
