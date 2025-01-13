package Topics.Arrays.Easy;
import java.util.Arrays;
//https://www.geeksforgeeks.org/problems/second-largest3735/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=second-largest
//sceond largest element
public class Quest7 {
    public static void main(String[] args) {
        int[] arr = {12,3,5,10,34,19};
        int result = secondLargest(arr);
        System.out.println("The Second largest element is : "+ result);
    }
    static int secondLargest(int[] arr){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]> largest){
                secondLargest = largest;
                largest = arr[i];
            }else if(arr[i] > secondLargest && arr[i] != largest){
                secondLargest = arr[i];
            }
        }
        if(secondLargest == Integer.MIN_VALUE){
            return -1;
        }

        return secondLargest;
    }
}
