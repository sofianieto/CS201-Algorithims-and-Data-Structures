
public class LinkedListPractice {
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode uno = l1;
	        ListNode dos = l2;
	        
	        int val1 = uno.val + dos.val;
	        ListNode head = new ListNode(val1);
	        ListNode pointer = head;
	        
	        l1 = l1.next;
	        l2 = l2.next;
	        
	        while(l1.next.next != null){
	        
	        int yay = l1.val + l1.val;
	        ListNode bed = new ListNode(yay);
	        pointer = bed;
	        pointer = pointer.next;
	 
	        }
	        
	        return head;
	    }
}


