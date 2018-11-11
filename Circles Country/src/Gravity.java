
public class Gravity {
public double falling(double time, double velo) {
double	d = time * velo + 0.5*9.8*Math.pow(time,2);
return d;
}

}
