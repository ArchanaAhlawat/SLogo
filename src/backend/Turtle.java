package backend;

import java.util.List;

public class Turtle implements Commands {

	// xcor=0, ycor=0 is in center
	// xcor increases to the right, ycor increases down
	// theta = 0 is pointed north (up)
	// theta is in degrees 0 to 360 going clockwise
	private double xcor, ycor, theta;
	private boolean penDown, turtleVis, trailClear;
//	private List<double[]> startLine;
//	private List<double[]> endLine;
	
	private static final double zero = 0.0;
	private static final double half = 0.5;
	

	public Turtle() {
		xcor = ycor = theta = zero;
		penDown = turtleVis = true;
	}
	
	public Turtle(double x, double y, double r, boolean penDown, boolean turtleVis) {
		this.xcor = x;
		this.ycor = y;
		this.theta = r;
		this.penDown = penDown;
		this.turtleVis = turtleVis;
	}

	private double distance(double x, double y) {
		return Math.pow(Math.pow(x - this.xcor, 2) + Math.pow(y - this.ycor, 2), half);
	}
	
	public void setTrailClear() {
		trailClear = false;
	}
	
	//TODO: getters and setters need to be wrapped 
	public double getXCor() {
		return xcor;
	}
	public double getYCor() {
		return ycor;
	}
	public double getHeading() {
		return theta;
	}
//	public double[] getPosition() {
//		return new double[] {xcor,ycor};
//	}

	public boolean getPenDown() {
		return penDown;
	}
	public boolean getTurtleVis() {
		return turtleVis;
	}

	@Override
	public double forward(double pixels) {
		this.xcor = this.xcor + pixels*Math.sin(this.theta);
		this.ycor = this.ycor - pixels*Math.cos(this.theta);
		return pixels;
	}

	@Override
	public double back(double pixels) {
		this.xcor = this.xcor - pixels*Math.sin(this.theta);
		this.ycor = this.ycor + pixels*Math.cos(this.theta);
		return pixels;
	}

	@Override
	public double left(double degrees) {
		this.theta = this.theta - degrees;
		return degrees;
	}

	@Override
	public double right(double degrees) {
		this.theta = this.theta + degrees;
		return degrees;
	}

	@Override
	public double setHeading(double degrees) {
		this.theta = degrees;
		return degrees;
	}

	@Override
	public double setXY(double[] xy) {
		double distance = distance(xy[0], xy[1]);
		this.xcor = xy[0];
		this.ycor = xy[1];
		return distance;
	}

	@Override
	public int penDown() {
		this.penDown = true;
		return 1;
	}

	@Override
	public int penUp() {
		this.penDown = false;
		return 0;
	}

	@Override
	public int showTurtle() {
		this.turtleVis = true;
		return 1;
	}

	@Override
	public int hideTurtle() {
		this.turtleVis = false;
		return 0;
	}

	@Override
	public double home() {
		double distance = distance(zero, zero);
		this.xcor = zero;
		this.ycor = zero;
		return distance;
	}

	@Override
	public double clearScreen() {
		trailClear = true;
		return this.home();
	}
}
