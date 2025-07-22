package Revise.StackAndQueues.Questions;

public class Quest3 {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("The total trap water is " + trap(arr));
    }
    static int trap(int[] arr){
     int n = arr.length-1;
     int left = 0;
     int right = n -1;
     int maxLeft = 0;
     int maxRight = 0;
     int res = 0;
     while(left <= right){
         if(arr[left] <= arr[right]){
             if(maxLeft <= arr[left]){
                 maxLeft = arr[left];
             }else{
              res += maxLeft - arr[left];
             }
             left++;
         }else {
             if(maxRight <= arr[right]){
                 maxRight = arr[right];
             }else{
                 res  +=  maxRight - arr[right];
             }
             right--;
         }
     }
     return res;
    }

}
//int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};