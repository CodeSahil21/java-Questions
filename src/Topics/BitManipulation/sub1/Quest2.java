package Topics.BitManipulation.sub1;

public class Quest2 {
    public static void main(String[] args) {
        int a = 10; // Example values
        int b = 20;

        swap(a, b);
    }
    public static void swap(int a, int b) {
        System.out.println("Before Swap: a = " + a + ", b = " + b);

        a = a ^ b;
        b = a ^ b;//(a^b) ^ b = a //(because b^b gets cancelled)
        a = a ^ b;//(a^b)^b= b//because now b= a therefore(a^a) get's cancelled

        System.out.println("After Swap: a = " + a + ", b = " + b);
    }
}

