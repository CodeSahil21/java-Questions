package Topics.LinkedList.DLL;

public class Main {
        public static void main(String[] args) {
           revrseDLL dll = new revrseDLL();

            // Insert elements
            dll.insertLast(1);
            dll.insertLast(2);
            dll.insertLast(3);
            dll.insertLast(4);
            System.out.println("Original List:");
            dll.display();

            // Reverse the list
            dll.reverseDLL();
            System.out.println("Reversed List:");
            dll.display();
        }
    }


