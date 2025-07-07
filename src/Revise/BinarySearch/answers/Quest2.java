package Revise.BinarySearch.answers;

public class Quest2 {
    public static void main(String[] args) {
        int n = 3, m = 27;
        int ans = NthRoot(n, m);
        System.out.println("The answer is: " + ans);
    }
    static int helperFunc(int mid,int n ,int m){
        long ans = 1;
        for(int i = 0; i  < n;i++){
            ans = ans *mid;
          if(ans > m){
              return 2;
          }
        }
        if(ans == m){
            return 1;
        }else if(ans < m){
            return 0;
        }
        return -1;
    }
    static int NthRoot(int n, int m){
        int start = 1;
        int end = m;
        while(start <= end){
            int mid = start + (end - start)/2;
            int result = helperFunc(mid,n,m);
            if(result == 1){
                return mid;
            }else if(result == 2){
                end = mid-1;
            }else if(result == 0){
                start = mid+1;
            }
        }
        return -1;
    }
}
