
public class RemoveN {

public ListNode move(ListNode list, int remove, int n) {
	ListNode saved = list;
ListNode splice = find(list,remove)	;// return node at which remove exists
if(splice == null)
	return list;

ListNode first = splice.next;
ListNode last = ith(first,n);

if(last == null)
	return saved;
if(last.next == null)
	return saved;


for(list = last; list.next != null; list =list.next);

splice.next = last.next;
list.next = first;
last.next = null;
return saved;

}
	/**
	 * Returns the first node containing key or
	 *   null if no element exists
	 */

	public ListNode find(ListNode list, int key) { 
	    if (list == null || list.info == key) 
				return list;
	    return find(list.next, key);
	}

	 // Returns the ith node in the list (1 is the 
	// initial node) or null if no such element exists
	 
	public ListNode ith(ListNode list, int i) {
	    if (i == 1 || list == null)
				return list;
	    return ith(list.next, i - 1);
	}
}