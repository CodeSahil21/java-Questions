package Revise.Arrays.Medium;

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
        static void setZeroes(int[][] arr){
            int[] row = new int[arr.length];
            int[] col = new int[arr[0].length];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if(arr[i][j] == 0){
                        row[i] = 1;
                        col[j] = 1;
                    }
                }
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if(row[i] == 1 || col[i] ==1){
                        arr[i][j] = 0;
                    }
                }
            }

        }

}
