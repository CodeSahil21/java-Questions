package Topics.BitManipulation.sub1;
//https://www.geeksforgeeks.org/problems/bit-manipulation-1666686020/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bit-manipulation
public class Quest1 {
    public static void main(String[] args) {
        int number = 10; // Example integer
        String binaryRepresentation = convert2Binary(number);
        System.out.println("Binary representation of " + number + " is: " + binaryRepresentation);
        String binaryString = "1111"; // Example binary string
        int decimalValue = convert2Decimal(binaryString);
        System.out.println("Decimal representation of " + binaryString + " is: " + decimalValue);
    }

    public static String convert2Binary(int n) {
        StringBuilder res = new StringBuilder();

        while (n != 1) {
            if (n % 2 == 1) {
                res.append('1');
            } else {
                res.append('0');
            }
            n = n / 2;
        }
        res.reverse();
        return res.toString();
    }
    public static int convert2Decimal(String n) {
        int len = n.length();
        int p2 = 1;
        int num = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (n.charAt(i) == '1') {
                num += p2;
            }
            p2 *= 2;
        }

        return num;
    }
}


