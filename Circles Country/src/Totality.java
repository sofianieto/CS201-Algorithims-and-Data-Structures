
public class Totality {
public int sum(int[] a,String stype) {
	int b=0;
if(stype.equals("even")) {
	for(int c=0; c< a.length; c+= 2) {
			b += a[c];			
		} 
}

else if(stype.equals("odd")) {
		for(int d=1; d< a.length; d+=2) {
			b += a[d];
		}
	}
	else if(stype.equals("all")) {
	for(int e=0; e < a.length; e++)	{
		b += a[e];
	}
	}

	return b;
}
}

