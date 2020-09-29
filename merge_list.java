// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED

class LNode{
	int data;
	LNode next;

	public LNode(){
		next = null;
	}

	public LNode(int data){
		this.data = data;
		next = null;
	}
}
public class merge_list
{ 
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public LNode mergeLists(LNode head1 , LNode head2)
	{
	    if(head1 == null) return head2;
	    if(head2 == null) return head1;
	    LNode temp = new LNode();
	    LNode res = temp;
	    while(head1 != null && head2 != null){
	        if(head1.data <= head2.data){
	            temp.data = head1.data;
	            head1 = head1.next;
	        }
	        else{
	            temp.data = head2.data;
	            head2 = head2.next;
	        }
	        temp.next = new LNode(); 
	        temp = temp.next;
	    }
	    if(head1 == null){
	        while(head2 != null){
	            temp.data = head2.data;
	            head2 = head2.next;
	            if(head2 != null) temp.next = new LNode();
	            temp = temp.next;
	        }
	    }
	    else{
	        while(head1 != null){
	            temp.data = head1.data;
	            head1 = head1.next;
	            if(head2 != null) temp.next = new LNode();
	            temp = temp.next;
	        }
	    }
	    return res;
	}
	// METHOD SIGNATURE ENDS
}
