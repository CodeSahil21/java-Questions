package Revise.Arrays.Easy;

public class Quest13 {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,7,8};
        int result = missinNumber(arr);
        System.out.println(result);
    }
    static int missinNumber(int[] arr){
        int xor1 = 0;
        int xor2 = 0;
        int N = arr.length;
        for(int i = 0 ;  i < arr.length-1; i++){
            xor1 = xor1 ^ arr[i];
            xor2 = xor2 ^ (i+1);
        }
        xor1 = xor1 ^ N;
        return (xor1 ^ xor2);
    }
}
