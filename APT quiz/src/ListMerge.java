
public class ListMerge {
	public ListNode merge (ListNode a, ListNode b){
	if(a == null)
		return b;
	if(b == null)
		return a;

	if(b.info < a.info) {
			  First = b;
			  merge(a,b.next);
		  }
	if(b.info > a.info) {
			  merge(a.next, b.next);
		  }
    if(b.info == a.info) {
      merge(a.next, b.next);
	}
    
}
