package Backend;

public class TurtleInfo {
	
	private double dx, dy, dr;
	private double absx, absy, absr;
	private boolean penDown, turtleVis;
	
	public TurtleInfo() {
		dx = dy = dr = absx = absy = absr = 0.0;
		penDown = turtleVis = true;
	}
	
	//TODO: getters and setters need to be wrapped 
	public double getdx() {
		return dx;
	}
	public double getdy() {
		return dy;
	}
	public double getdr() {
		return dr;
	}
	
	//instead of pairing the absx and absy together this (which is needed with SETXY or GOTO) we can include functionality to allow for setting one coordinate 
	public double getabsx() {
		return absx;
	}
	public double getabsy() {
		return absy;
	}
	public double getabsr() {
		return absr;
	}
	
	public boolean getPenDown() {
		return penDown;
	}
	public boolean getTurtleVis() {
		return turtleVis;
	}
	
}
