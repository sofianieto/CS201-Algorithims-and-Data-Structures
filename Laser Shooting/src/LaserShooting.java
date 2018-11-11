
public class LaserShooting {
public double numberOfHits(int[] x, int[] y1, int[] y2) {
double value = 0.0;
	for(int a = 0; a < x.length; a++) {
	
	double lineLength = Math.atan2( x[a], y1[a]) - Math.atan2(x[a], y2[a]);
	double lineProb = Math.abs(lineLength)/Math.PI;
			value += lineProb;
	}
	return value;
}
}
