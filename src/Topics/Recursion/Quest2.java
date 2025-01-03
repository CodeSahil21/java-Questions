package Topics.Recursion;
import java.util.*;
public class Quest2 {
    public static void main(String[] args) {
         //sumOfN(10,0);
//        int result = sumOfN(10);
        int result = factorial(5);
        System.out.println(result);
    }
    static void sumOfN(int i,int sum){
                  if(i < 1) {
                      System.out.println(sum);
                      return;
                  }
                  sumOfN(i-1,sum+i);
    }
    static int sumOfN(int n){
        if(n == 0){
            return 0;
        }
        return n + sumOfN(n-1);
    }
    static int factorial(int n){
        if(n < 2){
            return 1;
        }
        return n * factorial(n-1)
;    }
}
