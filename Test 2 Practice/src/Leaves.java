import java.util.ArrayList;

public class Leaves {
public int[] getLeaves(TreeNode t) {
ArrayList<Integer> al = new ArrayList<Integer>();
	if(t == null)
		return new int[0];
	if(t.left == null && t.right == null)
		al.add(t.info);
	if(t.left != null && t.left.right == null && t.left.left == null)
		al.add(t.left.info);
	if(t.right != null && t.right.right == null && t.right.left == null)
		al.add(t.right.info);
	if(t.left != null && !( t.left.right == null && t.left.left == null)) {
		int[] ba = getLeaves(t.left);
		for(int i=0; i < ba.length; i++) {
			al.add(ba[i]);
		}
	}
		
	
	if(t.right !=  null && !( t.right.right == null && t.right.left == null)) {
		int[] ba = getLeaves(t.right);
		for(int i=0; i < ba.length; i++) {
			al.add(ba[i]);
		}
	}
	   
int[] leaves = new int[al.size()];
		for(int i=0; i< leaves.length; i++)
		{
		leaves[i] = al.get(i).intValue();	
		}
	return leaves;
}
}

