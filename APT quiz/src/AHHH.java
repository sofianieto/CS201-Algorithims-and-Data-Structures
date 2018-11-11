
public class AHHH {

public class ListMerge {
	public ListNode merge (ListNode a, ListNode b){
		if(b== null)
			return a;
		if(a == null)
			return b;
		
		ListNode list =new ListNode(a.info, null);
		if(a.info < b.info) {
			a=a.next;
		}

		if(b.info < a.info) {
			list.info = b.info;
			b=b.next;
		}
		if(b.info == a.info) {
			a = a.next;
			b = b.next;

		}


		while(a.next != null && b.next!= null) {
			if(b.info < a.info) {
				list.next = new ListNode(b.info, null);
				b= b.next;
			}
		if(a.info < b.info) {
			list.next = new ListNode(a.info, null);
			b= a.next;
		}
		if(a.info == b.info) {
			list.next = new ListNode(a.info, null);
			a = a.next;
			b = b.next;			
		}
		}
		
		if(a.next != null) {
			if(b.info < a.info)
				list.next = new ListNode(b.info,a);
			if(a.info > b.info)
				list.next = new ListNode(a.info, new ListNode(b.info, a));
			list.next = a;
		}
		
		if(b.next != null)
			list.next = b;
		
return list;
	
	}
}
}
