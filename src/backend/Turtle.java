package backend;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kelly
 *
 */
public class Turtle {

	// xcor=0, ycor=0 is in center
	// xcor increases to the right, ycor increases down
	// theta = 0 is pointed north (up)
	// theta is in degrees 0 to 360 going clockwise
	private double xcor, ycor, theta;
	private double penDown, turtleVis;
	private List<double[]> startLine;
	private List<double[]> endLine;
	private List<String[]> colorLine;

	private static final double ZERO = 0.0;
	private static final double HALF = 0.5;
	private static final double ONE = 1.0;

	public Turtle() {
		xcor = ycor = theta = ZERO;
		penDown = ZERO;
		turtleVis = ONE;
	}

	public Turtle(double x, double y, double r, double penDown, double turtleVis) {
		this.xcor = x;
		this.ycor = y;
		this.theta = r;
		this.penDown = penDown;
		this.turtleVis = turtleVis;
	}
	
	private double xDisplacement(double x) {
		return x-this.xcor;
	}
	
	private double yDisplacement(double y) {
		return y-this.ycor;
	}

	private double distance(double x, double y) {
		return Math.pow(Math.pow(xDisplacement(x), 2) + Math.pow(yDisplacement(y), 2), HALF);
	}
	
	/**
	 * calculates the angle from north (up direction, 0 degrees) of the vector (x,y)
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @return the angle between north (0 degrees) and the vector (x,y)
	 */
	public double angle(double x, double y) {
		double xDis = xDisplacement(x);
		double yDis = yDisplacement(y);
		double angle = Math.atan(xDis/yDis);
		if (xDis >= 0 && yDis >= 0) {
			return angle;
		}
		else if (xDis <= 0 && yDis >= 0) {
			return 360 - angle;
		}
		else {
			return 180 + angle;
		}
	}

	//TODO: getters and setters need to be wrapped/use properties and bindings
	//all the information passers for the turtle queries
	/**
	 * used for the turtle query commands to observe specific parameters of turtle
	 * @param orientation the string that corresponds to which turtle parameter is wanted
	 * @return the value of the wanted turtle parameter
	 */
	public double getAbsoluteOrientation(String orientation) {
		try {
			Field t = Turtle.class.getDeclaredField(orientation);
			Object obj = Turtle.class.newInstance();
			System.out.println(obj);
			return (double) t.get(obj);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;
	}

	//all the active methods for the turtle (done using turtle commands)
	/**
	 * @param pixels
	 */
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
		double distance = distance(ZERO, ZERO);
		setXY(new double[] {ZERO, ZERO});
		return distance;
	}

	public double clearScreen() {
		startLine.clear();
		endLine.clear();
		colorLine.clear();
		return home();
	}
}
