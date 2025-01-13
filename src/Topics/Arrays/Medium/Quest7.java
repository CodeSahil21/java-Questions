package Topics.Arrays.Medium;

public class Quest7 {
    public static void main(String[] args) {
      int[] arr = {};
      int result = maxProduct(arr);
        System.out.println(result);
    }
///code with o(n^2) complexity
//    public static  int maxProduct(int[] nums) {
//      int max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int currproudct = 1;
//            for (int j = i; j <nums.length ; j++) {
//                currproudct = currproudct*nums[j];
//
//                max = Math.max(currproudct,max);
//            }
//        }
//        return max;
//    }
//
    public static  int maxProduct(int[] nums) {
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
