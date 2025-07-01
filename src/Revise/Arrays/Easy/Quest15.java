package Revise.Arrays.Easy;

public class Quest15 {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        int ans = getSingleElement(arr);
        System.out.println("The single element is: " + ans);

    }
    static int getSingleElement(int[] arr){
        int xor = 0;
        for(int i = 0; i< arr.length;i++){
             xor = xor ^ arr[i];
        }
        return xor;
    }
}

