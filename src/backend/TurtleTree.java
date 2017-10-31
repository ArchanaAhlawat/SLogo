package backend;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

/**
 * @author archana
 * @author kelly
 *
 */
public interface TurtleTree {
	public static final int DEGREESINCIRCLE = 360;
	public static final int NEGATE = -1;
	public static final double ZERO = 0.0;
	public static final double HALF = 0.5;
	public static final double ONE = 1.0;
	public static final double DEGTORAD = Math.PI/180.0;
	public static final double RADTODEG = 180/Math.PI;
	
	public List<Turtle> allTurtles = new ArrayList<Turtle>();
	public double xcor = 0;
	public double ycor = 0;
	public double theta = 0;
	public double penDown = 0;
	public double turtleVis = 0;
	public List<Double> lineCor = null;
	public List<Color> lineColor = null;
	public List<Double> lineThickness = null;
		
	public static final String CIRCLE = "circle";
	public static final String SQUARE = "square";
	public static final String TRIANGLE = "triangle";
	public static final String[] SHAPES = new String[] {CIRCLE, SQUARE, TRIANGLE};

	
	public double xDisplacement(double x);

	public double yDisplacement(double y);

	public double distance(double x, double y);
	
	/**
	 * calculates the angle from north (up direction, 0 degrees) of the vector (x,y)
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @return the angle between north (0 degrees) and the vector (x,y)
	 */
	public double[] angle(double x, double y);
	
	/**
	 * used for the turtle query commands to observe specific parameters of turtle
	 * @param orientation the string that corresponds to which turtle parameter is wanted
	 * @return the value of the wanted turtle parameter
	 */
	public double[] getAbsoluteOrientation(String orientation);
	
	/**
	 * length of this list will be a multiple of 4
	 * with the values x1, y1, x2, y2 for each line (1 is start point, 2 is end point)
	 * @return the coordinates of all of the lines
	 */
	public List<Double> getLines();
	
	/**
	 * length of this list will be a multiple of 2
	 * with the values x, y for each center of the stamp
	 * @return the coordinates of all of the circle stamps
	 */
	public List<Double> getCircleStamps();
	
	/**
	 * length of this list will be a multiple of 2
	 * with the values x, y for each center of the stamp
	 * @return the coordinates of all of the square stamps
	 */
	public List<Double> getSquareStamps();
	
	/**
	 * length of this list will be a multiple of 2
	 * with the values x, y for each center of the stamp
	 * @return the coordinates of all of the triangle stamps
	 */
	public List<Double> getTriangleStamps();
	
	/**
	 * moves the turtle pixels in the direction it is facing
	 * positive pixels is forward
	 * negative pixels is backward
	 * @param pixels
	 */
	public void move(double pixels);
	
	public void rotate(double degrees);
	
	public double setHeading(double[] expr1);
	
	public double setXY(double x, double y);
	
	public double stamp();
	
	public double setPenColor(int index);
	
	/**
	 * default indices are 1 - black, 2 - red, 3 - green, 4 - blue, 5 - white
	 * @return the index of the defined list of colors that the current pen color is set to
	 */
	public double getPenColor();
	
	public double setPenSize(double size);
	
	public double penChange(double change);
	
	public void setColorIndex(int index, int[] newColor);
	
	public ColorManager getColorManager();
	
	public double visChange(double change);
	
	public double home();
	
	public double clearScreen();
	
	public void clearStamps();
	
	public void addTurtle();
	
	public void addTurtle(double num);
	
	public void removeTurtle(double num);
	
	public double getSize();
	
	public double getActiveTurtleID();
	
	public void setActiveTurtles();
	
	public void addActiveTurtle();
	
	public void addActiveTurtle(double num);
	
	public void createTurtles(int num);
	
	public boolean containsID(double num);
	
	public void activateTurtle(double ID);
	
	public void reactivateTurtle(double num);
	
	public void clearActiveTurtles();

	public void deactivateTurtle(double id);

	public List<Turtle> getActiveTurtles();
}
