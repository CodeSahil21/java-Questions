package Revise.Arrays.Medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Quest4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {3,2,1,5,6,4};
        int k = in.nextInt();//to find kth largest element in array ex 2nd largest or 3rd largest
        //6,5,4,3,2,1
        int result = findKthLargest2(arr,k);
        System.out.println(result);
        in.close();
    }
    static int findKthLargest(int[] arr,int k){
        Arrays.sort(arr);
        reverse(arr);
        return arr[k-1];
    }
    static int findKthLargest2(int[] arr,int k){
       if(k > arr.length){
           return -1;
       }
        PriorityQueue<Integer> q = new PriorityQueue<>();

       for(int i = 0 ; i < arr.length;i++){
           q.offer(arr[i]);
           if(q.size() > k){
               q.poll();
           }
       }
       return (!q.isEmpty()) ? q.peek():-1;
    }


    static void reverse(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int temp  = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }
}
