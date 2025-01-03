package Topics.LinkedList.DLL;

public class revrseDLL extends DLL {
    public void reverseDLL(){
        Node current = head;
        Node prev1 = null;
        while(current != null){
            prev1 = current.prev;
            current.prev=current.next;
            current.next = prev1;
            current = current.prev;
        }
        if(prev1 != null){
            head = prev1.prev;
        }
    }
}
