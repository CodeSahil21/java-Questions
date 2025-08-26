package Revise.greedyalgo.medium;

public class Quest2 {
    public static void main(String[] args) {

    }
      public static boolean jump(int[] arr){
        int maxIndex = arr[0];
        for(int i = 0 ; i < arr.length;i++){
            if(i > maxIndex){
                return false;
            }
            maxIndex = Math.max(maxIndex,i + arr[i]);
        }
        return true;
      }
}
