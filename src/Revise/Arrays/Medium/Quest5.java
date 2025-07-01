package Revise.Arrays.Medium;

public class Quest5 {
    public static void main(String[] args) {
        int[] height = {3, 1, 2, 4, 0, 1, 3, 2};
        System.out.println("Trapped water: " + trap(height));
    }

    static int trap(int[] arr){
        int[] right = new int[arr.length];
        int[] left = new int[arr.length];
        right[arr.length-1] = arr[arr.length-1];
        for(int i = arr.length-2 ; i >= 0; i-- ){
            right[i]= Math.max(right[i+1],arr[i]);
        }
        left[0] = arr[0];
        for(int i = 1 ; i < arr.length;i++){
            left[i] = Math.max(left[i-1],arr[i]);
        }
        int trapWater = 0;
        for(int i = 0 ; i < arr.length; i++ ){
            trapWater += Math.min(left[i],right[i])-arr[i];
        }
        return trapWater;
    }

}
