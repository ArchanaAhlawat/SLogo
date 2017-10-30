package backend;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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
public class Turtle implements TurtleTree {
	
	private List<Double> allIDs = new ArrayList<Double>();
	private double xcor, ycor, theta;
	private double penDown, turtleVis;
	private List<Double> lineCor;
	private List<Double> circleStamps;
	private List<Double> squareStamps;
	private List<Double> triangleStamps;
	private int stamp;
	private int[] penColor;
	private double penSize;
	private double turtleCount = 1;
	protected double turtleID = 1;
	
	private ColorManager myColors;
	
	public Turtle() {
		myColors = new ColorManager();
		xcor = ycor = theta = ZERO;
		penDown = ZERO;
		turtleVis = ONE;
		lineCor = new ArrayList<Double>();
		penColor = new int[] {0,0,0};//BLACK;
		penSize = ONE;
		stamp = 1;
	}

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

	@Override
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

	@Override
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

	@Override
	public List<Double> getLines() {
		return lineCor;
	}
	
	@Override
	public List<Double> getCircleStamps() {
		return circleStamps;
	}
	
	@Override
	public List<Double> getSquareStamps() {
		return squareStamps;
	}
	
	@Override
	public List<Double> getTriangleStamps() {
		return triangleStamps;
	}

	@Override
	public void move(double pixels) {
		System.out.println("x is: " + xcor);
		System.out.println("y is: " + ycor);
		double newx = xcor - pixels*Math.sin(theta*DEGTORAD);
		double newy = ycor + pixels*Math.cos(theta*DEGTORAD);
		System.out.println("new x is: " + newx);
		System.out.println("new y is: " + newy);
		setXY(newx, newy);
	}

	@Override
	public void rotate(double degrees) {
		double newtheta = theta + degrees;
		setHeading(new double[] {newtheta});
	}
	
	@Override
	public double setHeading(double[] expr1) {
		System.out.println("turn to: " + expr1[0]);
		System.out.println("current angle: " + theta);
		double difference = Math.abs(expr1[0] - theta);
		theta = (((expr1[0]) % DEGREESINCIRCLE) + DEGREESINCIRCLE) % DEGREESINCIRCLE;;
		System.out.println("new angle: " + theta);
		System.out.println("difference: " + difference);
		return difference;
	}

	@Override
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

	public double stamp() { //better with reflection
		if (stamp == 1) {
			circleStamps.add(xcor);
			circleStamps.add(ycor);
		}
		else if (stamp == 2) {
			squareStamps.add(xcor);
			squareStamps.add(ycor);
		}
		else {
			triangleStamps.add(xcor);
			triangleStamps.add(xcor);
		}
		return stamp;
	}
	
	@Override
	public double setPenColor(int index) {
		penColor = myColors.getColor(index);
		return index;
	}
	
	@Override
	public double getPenColor() {
		return myColors.getIndex(penColor);
	}
	
	@Override
	public double setPenSize(double size) {
		penSize = size;
		return size;
	}
	
	@Override
	public double penChange(double change) {
		penDown = change;
		return change;
	}

	@Override
	public void setColorIndex(int index, int[] newColor) {
		myColors.setIndex(index, newColor);		
	}
	
	@Override
	public ColorManager getColorManager() {
		return myColors;
	}

	@Override
	public double visChange(double change) {
		turtleVis = change;
		return change;
	}

	@Override
	public double home() {
		return setXY(ZERO, ZERO);
	}

	@Override
	public double clearScreen() {
		double returnVal = home();
		lineCor.clear();
		clearStamps();
		return returnVal;
	}
	
	public void clearStamps() {
		circleStamps.clear();
		squareStamps.clear();
		triangleStamps.clear();
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
