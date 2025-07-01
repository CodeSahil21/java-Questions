package Revise.Arrays.Easy;

public class Quest1 {
    public static void main(String[] args) {
        int[] arr = { 4, 9, 6, 5, 2, 3 };
        maxAndMin(arr);
    }

    static void maxAndMin(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("Minimum element is : " + min);
        System.out.println("Maximum element is : " + max);
    }
}
