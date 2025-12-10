package Topics.Arrays.Medium;
//https://leetcode.com/problems/rotate-image/description/
//rotate matrix by 90 degree
public class Quest18 {
    public static void main(String[] args) {
        int[][] arr =   {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};
         rotate(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void rotate(int[][] matrix) {
        //transpose of row
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[0].length ; j++) {
              int temp = matrix[i][j];
              matrix[i][j] = matrix[j][i];
              matrix[j][i] = temp;
            }
        }
        //reverse each row
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length/2; j++) {
                 int temp  = matrix[i][j];
                 matrix[i][j] =  matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}
