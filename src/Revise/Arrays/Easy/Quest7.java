package Revise.Arrays.Easy;

public class Quest7 {
    public static void main(String[] args) {
        int[] arr = {12,3,5,10,34,19,33};
        int result = secondLargest(arr);
        System.out.println("The Second largest element is : "+ result);
    }

    static int secondLargest(int[] arr){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i = 0 ; i< arr.length; i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }
            if(arr[i] > secondLargest && arr[i] != largest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

}
