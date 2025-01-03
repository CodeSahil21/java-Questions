package Topics.LinkedList.LL;
//https://leetcode.com/problems/add-two-numbers/description/
public class Add2no extends LL{
      public Node addTwoNumbers(Node num1,Node num2){
          Node dummyHead = new Node(-1);
          Node current = dummyHead;
          Node temp1 = num1;
          Node temp2 =  num2;
          int carry =0;
          while(temp1!= null || temp2!=null){
              int sum = carry;
              if(temp1 !=  null){
                  sum += temp1.value;
                  temp1 = temp1.next;
              }
              if(temp2 != null){
                  sum += temp2.value;
                  temp2 = temp2.next;
              }
              Node newNode = new Node(sum%10);
              carry = sum/10;

              current.next = newNode;
              current = current.next;
          }
          if(carry > 0){
              Node newNode = new Node(carry);
              current.next = newNode;
          }
          return dummyHead.next;//head = dummyHead.next
      }
}
