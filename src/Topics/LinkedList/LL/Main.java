package Topics.LinkedList.LL;

import java.util.Arrays;

public class Main {
        public static void main(String[] args) {
//            Add2no list1 = new Add2no();
//            list1.insertLast(2);
//            list1.insertLast(4);
//            list1.insertLast(3);
//            System.out.println("First Number:");
//            list1.display();
//
//            Add2no list2 = new Add2no();
//            list2.insertLast(5);
//            list2.insertLast(6);
//            list2.insertLast(6);
//            System.out.println("Second Number:");
//            list2.display();
//
//            Add2no result = new Add2no();
//            result.head = result.addTwoNumbers(list1.head, list2.head);
//            System.out.println("Sum of Numbers:");
//            result.display();

            LL list1 = new LL();
            list1.insertLast(3);
            list1.insertLast(1);
            list1.insertLast(4);
            list1.insertLast(6);
            list1.insertLast(2);
            list1.display();
            LL list2 = new LL();
            list2.insertLast(1);
            list2.insertLast(2);
            list2.insertLast(3);
            list2.insertLast(4);
            list2.insertLast(5);
            list2.insertLast(6);
            list2.insertLast(7);
            list2.display();



        }
    }

