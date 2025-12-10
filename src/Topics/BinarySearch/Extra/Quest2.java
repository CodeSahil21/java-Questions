package Topics.BinarySearch.Extra;

public class Quest2 {

    static double Quest(int[] arr,int k){
      double start = 0;
      double end = 0;
        for (int i = 0; i < arr.length; i++) {
            end = Math.max(end, ((double)(arr[i+1] - arr[i])));
        }
        double diff = 1e-6;
      while(end - start  > diff){
          double mid = (start + end)/2.0;
          int result = helperFunc(arr,k,mid);
          if(result > k){
              start = mid;
          }else{
              end = mid;
          }
      }

      return  end;
    }
    public static int maxsum(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public static  int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    static int helperFunc(int[] nums,int m,double dist){
        int cnt = 0;
        for (int i = 1; i < nums.length ; i++) {
            int numberInBetween = (int)((nums[i] - nums[i - 1]) / dist);
            if ((nums[i] - nums[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }
}
