package Revise.Arrays.Easy;

public class Quest14 {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1};
        int result =  findMaxConsecutiveOnes(arr);
        System.out.println(result);
    }
    static int findMaxConsecutiveOnes(int[] arr){
        int maxCount = 0;
        int count = 0;
        for(int i = 0 ; i< arr.length;i++){
            if(arr[i]== 1){
                count++;
             maxCount = Math.max(count,maxCount);
            }else{
                count = 0;
            }
        }
        return maxCount;
    }
}
