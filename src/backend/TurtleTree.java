package backend;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

/**
 * @author archana
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

	
	/**
	 * calculates x displacement for a turtle
	 * @param x
	 * @return the difference between the current x cor and the parameter x
	 */
	public double xDisplacement(double x);

	/**
	 * calculates y displacement for a turtle
	 * @param y
	 * @return the difference between the current y cor and the parameter y
	 */
	public double yDisplacement(double y);

	/**
	 * calculates the distance between (x,y) and a turtle's location
	 * @param x
	 * @param y
	 * @return the distance
	 */
	public double distance(double x, double y);
	
	/**
	 * calculates the angle from north (up direction, 0 degrees) of the vector (x,y)
	 * value is between 0 and 360
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
	 * @param pixels to change x,y location of turtle by
	 */
	public void move(double pixels);
	
	/**
	 * rotates the turtle the number of degrees
	 * positive degrees is right
	 * negative degrees is left
	 * @param degrees to change theta (heading) by
	 */
	public void rotate(double degrees);
	
	/**
	 * sets the turtle's heading to the input
	 * @param expr1
	 * @return the number of degrees turned
	 */
	public double setHeading(double[] expr1);
	
	/**
	 * sets the turtle's x,y to the input
	 * @param x
	 * @param y
	 * @return the distance moved by the turtle
	 */
	public double setXY(double x, double y);
	
	/**
	 * supposed to leave a stamp/mark on the grid?
	 * not quite sure how this was supposed to be implemented (was not on website)
	 * @return type of stamp
	 */
	public double stamp();
	
	/**
	 * changes the pen's color to the color at the index provided
	 * @param index we want the new pen color to be
	 * @return index of the new pen color
	 */
	public double setPenColor(int index);
	
	/**
	 * default indices are 1 - black, 2 - red, 3 - green, 4 - blue, 5 - white
	 * @return the index of the defined list of colors that the current pen color is set to
	 */
	public double getPenColor();
	
	/**
	 * sets the pen's size (in pixels) to the size entered
	 * @param size
	 * @return size
	 */
	public double setPenSize(double size);
	
	/**
	 * used for penup/down commands to change the pen's state
	 * @param change
	 * @return the change that happened (0.0 for penUp, 1.0 for penDown)
	 */
	public double penChange(double change);
	
	/**
	 * edits the default color at index in ColorManager
	 * @param index
	 * @param newColor
	 */
	public void setColorIndex(int index, int[] newColor);
	
	/**
	 * used to access the color manager associated with a turtle
	 * @return ColorManager for the turtle
	 */
	public ColorManager getColorManager();
	
	/**
	 * edits the visibility of a turtle
	 * @param change
	 * @return the change that happeneds
	 */
	public double visChange(double change);
	
	/**
	 * moves the turtle home, and clears all of the lines and stamps
	 * @return the distance the turtle traveled to home
	 */
	public double clearScreen();
	
	/**
	 * just clears all of the stamps
	 */
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

	public String getError();

	public void resetError();
}
