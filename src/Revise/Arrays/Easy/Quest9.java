package Revise.Arrays.Easy;

import java.util.Arrays;

public class Quest9 {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int result = removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(result);

    }
    static  int removeDuplicates(int[] arr){
        int j = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[j]  != arr[i]) {
                arr[j + 1] = arr[i];
                j++;
            }
        }
        return j+1;
    }

}
