package backend;

import java.util.ArrayList;
import java.util.List;

public class Turtle {

	// xcor=0, ycor=0 is in center
	// xcor increases to the right, ycor increases down
	// theta = 0 is pointed north (up)
	// theta is in degrees 0 to 360 going clockwise
	private double xcor, ycor, theta;
	private double penDown, turtleVis, trailClear;
	private List<double[]> startLine;
	private List<double[]> endLine;
	private List<String[]> colorLine;
	
	private static final double zero = 0.0;
	private static final double half = 0.5;
	

	public Turtle() {
		xcor = ycor = theta = zero;
		penDown = turtleVis = 1.0;
	}
	
	public Turtle(double x, double y, double r, double penDown, double turtleVis) {
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
		trailClear = 0.0;
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

	public int getPenDown() {
		return (int) penDown;
	}
	public int getTurtleVis() {
		return (int) turtleVis;
	}

	public void move(double pixels) {
		this.xcor = this.xcor + pixels*Math.sin(this.theta);
		this.ycor = this.ycor - pixels*Math.cos(this.theta);
	}
	
	public void rotate(double degrees) {
		this.theta = this.theta + degrees;
	}
	
	public double setHeading(double degrees) {
		double difference = degrees - this.theta;
		this.theta = degrees;
		return difference;
	}

	public double setXY(double[] xy) {
		double distance = distance(xy[0], xy[1]);
		this.xcor = xy[0];
		this.ycor = xy[1];
		return distance;
	}

	public int penChange(double change) {
		this.penDown = change;
		return (int) change;
	}

	public int visChange(double change) {
		this.turtleVis = change;
		return (int) change;
	}

	public double home() {
		double distance = distance(zero, zero);
		setXY(new double[] {zero, zero});
		return distance;
	}

	public double clearScreen() {
		trailClear = 1.0;
		return this.home();
	}
}
