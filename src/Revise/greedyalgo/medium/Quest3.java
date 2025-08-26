package Revise.greedyalgo.medium;

public class Quest3 {
    public static void main(String[] args) {

    }
    public static int jump2(int[] arr){
        int jumps = 0;
        int left = 0;
        int right = 0;
        while(right < arr.length-1 ){
            int farthest = 0;
            for (int i = left; i <= right ; i++) {
                farthest = Math.max(farthest,i + arr[i]);
            }
             left = right +1;
             right = farthest;
             jumps++;
        }
        return jumps;
    }
}
