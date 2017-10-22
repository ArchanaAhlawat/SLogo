package frontend;

public class VectorCalc {
	
	private static double[] vector(double angle) {
		double m = 1/(Math.tan(angle));
		double[] ret = new double[2];
		ret[0] = 1.0;
		ret[1] = m;
		return ret;
	}
	
	private static double[] uVector(double[] vector) {
		double mag = Math.sqrt(vector[0]*vector[0] + vector[1]*vector[1]);
		for(Double el : vector) {
			el /= mag;
		}
		return vector;
	}
	
	public static double[] nPoint(double[] oPoint, double dist, double angle, boolean fwd) {
		double[] vector = vector(angle);
		double[] uVector = uVector(vector);
		double[] nPoint = new double[2];
		for(int i = 0; i < 2; i++) {
			if(fwd) nPoint[i] = oPoint[i] + dist*uVector[i];
			else nPoint[i] = oPoint[i] - dist*uVector[i];
		}
		return nPoint;
	}
	
	public static double distance(double[] a,double[] b) {
		return Math.sqrt((b[0] - a[0])*(b[0] - a[0]) + (b[1] - a[1])*(b[1] - a[1]));
	}
}
