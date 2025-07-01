package Revise.Arrays.Medium;

public class Quest7 {
    public static void main(String[] args) {
        int[] arr = {};
        int result = maxProduct(arr);
        System.out.println(result);
    }
    //ON^2
    static int maxProduct(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length;i++){
            int curr = 1;
            for(int j = 0 ;j < arr.length;j++){
                 curr = curr *arr[i];

                 max = Math.max(max,curr);
            }
        }
        return max;
    }

    static int maxproductON(int[] nums){
        int maxproduct = nums[0];
        int minproduct = nums[0];
        int result =     nums[0];
        for(int i = 1; i < nums.length ; i++) {
            int current = nums[i];
            //if current number is negative swap maxproduct and minproduct
            if(current < 0){
                int temp = maxproduct;
                maxproduct = minproduct;
                minproduct = temp;
            }
            maxproduct = Math.max(current,maxproduct*current);
            minproduct = Math.min(current,minproduct*current);

            result = Math.max(result,maxproduct);
        }
        return result;
    }
}
