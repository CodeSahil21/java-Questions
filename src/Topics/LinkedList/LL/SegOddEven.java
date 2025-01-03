package Topics.LinkedList.LL;

public class SegOddEven extends LL{
      public Node oddEvenList(){
          if(head == null){
              return null;
          }
          Node odd = head;
          Node even = head.next;
          Node evenHead = head.next;
          while(even != null && even.next != null){
              odd.next = odd.next.next;
              even.next = even.next.next;

              odd = odd.next;
              even = even.next;
          }
          odd.next = evenHead;
          return head;
      }
}
