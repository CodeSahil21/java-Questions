package Topics.Recursion;
//https://youtu.be/kvRjNm4rVBE?feature=shared
public class Quest4 {
    public static void main(String[] args) {
        System.out.println(fibo(10));
    }
    static int fibo(int n){
        if(n <= 1){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
}
