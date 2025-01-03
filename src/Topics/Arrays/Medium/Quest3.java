package Topics.Arrays.Medium;

import java.util.Arrays;

public class Quest3 {
//https://www.interviewbit.com/problems/repeat-and-missing-number-array/discussion/
    // repeat and  missing number array
    public static void main(String[] args) {
        int[] arr = {3,1,2,5,3};
        System.out.println(Arrays.toString(repeatedNumber(arr)));

    }
    //time complexity and space complexity
    public  static int[] repeatedNumber(final int[] A) {
        //step first sort the array using cyclic sort since 1 to N
        int i = 0;
        while(i < A.length){
            //1,2,3,4,5
            int correctindex = A[i] -1;
            if(A[i] != A[correctindex]){
                swap(A,i,correctindex);
            }else{
                i++;
            }
        }
        ///1,2,3,3,5 :we iterate over sorted array and check whether A[j] = j+1 since it is 1 to n
        for(int j = 0; j <A.length;j++){
            if(A[j] != j+1){//if we find A[i] != i+1 means we found our nswer such A[i] is repeated and i+1 is missing number
                return new int[] {A[j],j+1};
            }
        }
        return new int[] {-1,-1};
    }
    static void swap(int[] arr, int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
