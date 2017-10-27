package backend;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

/**
 * Turtle that keeps track of all of their locations and parameters needed
 * has a constructor that sets up the original turtle and one to set up a turtle with initial parameters
 * has active methods to create all changes from turtlecommands
 * has getter that uses reflection to return each of the parameters needed
 * has a getter that returns the lines/trails to be drawn
 * 
 * @author kelly
 * 
 */
public class Turtle {
	private static final int DEGREESINCIRCLE = 360;
	private static final int NEGATE = -1;
	private static final double ZERO = 0.0;
	private static final double HALF = 0.5;
	private static final double ONE = 1.0;
	private static final double DEGTORAD = Math.PI/180.0;
	private static final double RADTODEG = 180/Math.PI;

	// xcor=0, ycor=0 is in center
	// xcor increases to the right, ycor increases down
	// theta = 0 is pointed north (up)
	// theta is in degrees 0 to 360 going clockwise
	private double xcor, ycor, theta;
	private double penDown, turtleVis;
	private List<Double> lineCor;
	private List<Color> lineColor;
	private List<Double> lineThickness;
	
	public Turtle() {
		xcor = ycor = theta = ZERO;
		penDown = ZERO;
		turtleVis = ONE;
		lineCor = new ArrayList<Double>();
	}

	public Turtle(double x, double y, double t, double pD, double tV) {
		xcor = x;
		ycor = y;
		theta = t;
		penDown = pD;
		turtleVis = tV;
		lineCor = new ArrayList<Double>();
		lineColor = new ArrayList<Color>();
		lineThickness= new ArrayList<Double>();
	}

	private double xDisplacement(double x) {
		return x-xcor;
	}

	private double yDisplacement(double y) {
		return y-ycor;
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
		double angle = Math.atan(xDis/yDis)*RADTODEG;
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
			return t.getDouble(this);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;
	}

	/**
	 * @return
	 */
	public List<Double> getLines() {
		return lineCor;
	}

	//all the active methods for the turtle (done using turtle commands)
	/**
	 * @param pixels
	 */
	public void move(double pixels) {
		System.out.println("x is: " + xcor);
		System.out.println("y is: " + ycor);
		double newx = xcor + pixels*Math.sin(theta*DEGTORAD);
		double newy = ycor - pixels*Math.cos(theta*DEGTORAD);
		System.out.println("new x is: " + newx);
		System.out.println("new y is: " + newy);
		setXY(newx, newy);
	}

	public void rotate(double degrees) {
		double newtheta = theta + degrees;
		setHeading(newtheta);
	}

	public double setHeading(double degrees) {
		double difference = Math.abs(degrees - theta);
		//https://stackoverflow.com/questions/5385024/mod-in-java-produces-negative-numbers
		theta = ((degrees % DEGREESINCIRCLE) + DEGREESINCIRCLE) % DEGREESINCIRCLE;
		return difference;
	}

	public double setXY(double x, double y) {
		if (penDown == ONE) {
			lineCor.add(xcor);
			lineCor.add(ycor);
			lineCor.add(x);
			lineCor.add(y*NEGATE);
		}
		System.out.println(lineCor);
		double distance = distance(x, y);
		xcor = x;
		ycor = y;
		return distance;
	}

	public double penChange(double change) {
		penDown = change;
		return change;
	}

	public double visChange(double change) {
		turtleVis = change;
		return change;
	}

	public double home() {
		double distance = distance(ZERO, ZERO);
		setXY(ZERO, ZERO);
		return distance;
	}

	public double clearScreen() {
		lineCor.clear();
		return home();
	}

//	public static void main (String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
//		Turtle t = new Turtle(5.0,2.0,3.0,0.0,0.0);
//		System.out.println(t.getAbsoluteOrientation("xcor"));
//		System.out.println(t.getAbsoluteOrientation("ycor"));
//		System.out.println(t.getAbsoluteOrientation("theta"));
//		System.out.println(((-90%360)+360)%360);
//	}
}
