package Topics.Recursion;

import java.util.*;

//https://youtu.be/twuC1F6gLI8?feature=shared
public class Quest3 {
    public static void main(String[] args) {
 int[] arr ={1,2,3,4,5};
// reverse(0,arr.length-1,arr);
 reverse2(0,arr);
 String s = "MADAM";
        System.out.println(ispalindrome(s,0));
    }
    static void reverse(int start, int end,int[] arr){
        if(start >= end){
            System.out.println(Arrays.toString(arr));
            return;
        }
        swap(arr,start ,end);
        reverse(start+1,end-1,arr);
    }
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void reverse2(int i , int[] arr){
        if(i >= arr.length/2){
            System.out.println(Arrays.toString(arr));
            return;
        }
        swap(arr,i,arr.length-i-1);
        reverse2(i+1,arr);
    }

    static boolean ispalindrome(String s,int i){
        if(i >= s.length()/2){
            return true;
        }
        if(s.charAt(i) != s.charAt(s.length()-i-1)){
            return false;
        }
       return ispalindrome(s,i+1);
    }
}
