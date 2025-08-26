package Revise.greedyalgo.easy;

public class Quest3 {
    public static void main(String[] args) {
        System.out.println(checkValidString("(*)"));  // true
        System.out.println(checkValidString("(*))")); // true
        System.out.println(checkValidString("((*)")); // true
        System.out.println(checkValidString("())"));  // false
    }
    public  static boolean checkValidString(String s) {

        int minOpen = 0, maxOpen = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                minOpen++;
                maxOpen++;
            } else if (ch == ')') {
                minOpen = Math.max(0, minOpen - 1);
                maxOpen--;
            } else { // '*'
                minOpen = Math.max(0, minOpen - 1);
                maxOpen++;
            }
            if (maxOpen < 0) return false;
        }

        return minOpen == 0;
    }


}
