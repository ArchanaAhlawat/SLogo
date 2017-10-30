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
public class Turtle implements TurtleTree{
	
	private List<Double> allIDs = new ArrayList<Double>();
	private double xcor, ycor, theta;
	private double penDown, turtleVis;
	private List<Double> lineCor;
	private int[] penColor;
	private double lineThickness;
	private double turtleCount = 1;
	protected double turtleID = 1;

	
	public Turtle() {
		xcor = ycor = theta = ZERO;
		penDown = ZERO;
		turtleVis = ONE;
		lineCor = new ArrayList<Double>();
		penColor = BLACK;
		lineThickness= ONE;
	}

//	public Turtle(double x, double y, double t, double pD, double tV) {
//		xcor = x;
//		ycor = y;
//		theta = t;
//		penDown = pD;
//		turtleVis = tV;
//		lineCor = new ArrayList<Double>();
//		lineColor = Color.BLACK;
//		lineThickness= ONE;
//	}

	@Override
	public double xDisplacement(double x) {
		return x-xcor;
	}
	
	@Override
	public double yDisplacement(double y) {
		return y-ycor;
	}

	@Override
	public double distance(double x, double y) {
		return Math.pow(Math.pow(xDisplacement(x), 2) + Math.pow(yDisplacement(y), 2), HALF);
	}

	/**
	 * calculates the angle from north (up direction, 0 degrees) of the vector (x,y)
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @return the angle between north (0 degrees) and the vector (x,y)
	 */
	public double[] angle(double x, double y) {
		double xDis = xDisplacement(x);
		double yDis = yDisplacement(y);
		double angle = Math.atan(xDis/yDis)*RADTODEG;
		if (yDis <= ZERO) { //first and fourth quadrants
			return new double[] {(((DEGREESINCIRCLE + NEGATE*angle) % DEGREESINCIRCLE) + DEGREESINCIRCLE) % DEGREESINCIRCLE};
		}
		else { //second and third quadrants
			return new double[] {(((DEGREESINCIRCLE*HALF + NEGATE*angle) % DEGREESINCIRCLE) + DEGREESINCIRCLE) % DEGREESINCIRCLE};
		}
	}

	//TODO: getters and setters need to be wrapped/use properties and bindings
	//all the information passers for the turtle queries
	/**
	 * used for the turtle query commands to observe specific parameters of turtle
	 * @param orientation the string that corresponds to which turtle parameter is wanted
	 * @return the value of the wanted turtle parameter
	 */
	public double[] getAbsoluteOrientation(String orientation) {
		try {
			Field t = Turtle.class.getDeclaredField(orientation);
			return new double[] {t.getDouble(this)};
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @return
	 */
	public List<Double> getLines() {
		return lineCor;
	}
	
	/**
	 * @return
	 */
	public int[] getPenColor() {
		return penColor;
	}

	//all the active methods for the turtle (done using turtle commands)
	/**
	 * @param pixels
	 */
	public void move(double pixels) {
		System.out.println("x is: " + xcor);
		System.out.println("y is: " + ycor);
		double newx = xcor - pixels*Math.sin(theta*DEGTORAD);
		double newy = ycor + pixels*Math.cos(theta*DEGTORAD);
		System.out.println("new x is: " + newx);
		System.out.println("new y is: " + newy);
		setXY(newx, newy);
	}

	public void rotate(double degrees) {
		double newtheta = theta + degrees;
		setHeading(new double[] {newtheta});
	}
	
	public double setHeading(double[] expr1) {
		System.out.println("turn to: " + expr1[0]);
		System.out.println("current angle: " + theta);
		double difference = Math.abs(expr1[0] - theta);
		theta = (((expr1[0]) % DEGREESINCIRCLE) + DEGREESINCIRCLE) % DEGREESINCIRCLE;;
		System.out.println("new angle: " + theta);
		System.out.println("difference: " + difference);
		return difference;
	}

	public double setXY(double x, double y) {
		if (penDown == ONE) {
			lineCor.add(xcor);
			lineCor.add(ycor);
			lineCor.add(x);
			lineCor.add(y);
		}
		System.out.println(lineCor);
		double distance = distance(x, y);
		xcor = x;
		ycor = y;
		return distance;
	}

	public double setLineColor(int index) {
		penColor = COLORS[index];
		return index;
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
		//double returnVal = setXY(ZERO, ZERO);
		//System.out.println(returnVal);
		//return returnVal;
		return setXY(ZERO, ZERO);
	}

	public double clearScreen() {
		penDown = ZERO;
		lineCor.clear();
		//double returnVal = home();
		//System.out.println(returnVal);
		//return returnVal;
		return home();
	}

	@Override
	public void addTurtle() {
		// do nothing 
	}

	@Override
	public void removeTurtle(double num) {
		// do nothing
		
	}

	@Override
	public double getSize() {
		return turtleCount;
	}

	@Override
	public double getActiveTurtleID() {
		return this.turtleID;
	}

	@Override
	public void setActiveTurtles() {
		// do nothing
	}

	public void setTurtleID(double id) {
		System.out.println("id: " + id);
		turtleID = id;
	}
	
	public void addActiveTurtle() {
		// do nothing. 
	}

	@Override
	public void createTurtles(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTurtle(double num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addActiveTurtle(double num) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean containsID(double num) {
		return (allIDs.contains(num));
	}

	@Override
	public void activateTurtle(double ID) {
		// TODO Auto-generated method stub
	}

	@Override
	public void clearActiveTurtles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reactivateTurtle(double num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivateTurtle(double id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Turtle> getActiveTurtles() {
		// TODO Auto-generated method stub
		return null;
	}
}
