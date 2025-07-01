package Revise.Arrays.Easy;
import java.util.Arrays;

public class Quest4 {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        System.out.println(containsDuplicate(arr));
    }
     static boolean containsDuplicate(int[] arr){
        if(arr.length == 0){
            return false;
        }
        Arrays.sort(arr);
         for (int i = 1; i < arr.length; i++) {
             if(arr[i] == arr[i-1]){
                 return true;
             }
         }
         return false;
     }

}
