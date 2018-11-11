
public class ListLastFirst {


	public ListNode move(ListNode list) {
		ListNode first = list;
		if(list == null || list.next == null) {
			return first;
		}else {
			while (list.next.next != null) {
				list = list.next;
			}
			ListNode ba = new ListNode(list.next.info, first); // why can not do .info
			list.next = null;
			return ba;
		}
	}	
}
