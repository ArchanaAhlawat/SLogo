package backend;

import java.util.List;

/**
 * Used to send all of the updated information to the front end
 * @author kelly
 *
 */
public class Updates {
	private static final String XCOR = "xcor";
	private static final String YCOR = "ycor";
	private static final String THETA = "theta";
	private static final String PENDOWN = "penDown";
	private static final String TURTLEVIS = "turtleVis";	
	private double xcor, ycor, theta, penDown, turtleVis;
	private List<Double> lineCor, circleStamps, squareStamps, triangleStamps;
	private int penColor;
	private String error;
	private TurtleTree myTurtle;
	
	public Updates(TurtleTree currentTurtle) { // ONE TURTLE ONLY
		myTurtle = currentTurtle;
		xcor = myTurtle.getAbsoluteOrientation(XCOR)[0];
		System.out.println("updated Turtle xCor from Updates: " + xcor);
		ycor = myTurtle.getAbsoluteOrientation(YCOR)[0];
		theta = myTurtle.getAbsoluteOrientation(THETA)[0];
		penDown = myTurtle.getAbsoluteOrientation(PENDOWN)[0];
		turtleVis = myTurtle.getAbsoluteOrientation(TURTLEVIS)[0];
		lineCor = myTurtle.getLines();
		circleStamps = myTurtle.getCircleStamps();
		penColor = (int) myTurtle.getPenColor();
		error = myTurtle.getError();
	}
	
	/**
	 * @return the xcor that the turtle should be updated to within the gridpane
	 */
	public double getXCor() {
		return xcor;
	}
	
	/**
	 * @return the ycor that the turtle should be updated to within the gridpane
	 */
	public double getYCor() {
		return ycor;
	}
	
	/**
	 * @return the angle that the turtle should be facing 12oclock/north is 0 degrees and increases clockwise within the gridpane (0 to 360)
	 */
	public double getTheta() {
		return theta;
	}
	
	/**
	 * @return if the pen is down
	 */
	public double getPenDown() {
		return penDown;
	}
	
	/**
	 * @return if the turtle is visible
	 */
	public double getTurtleVis() {
		return turtleVis;
	}
	
	/**
	 * @return the coordinates of the lines that need to be displayed on the front end (will be empty if there are no lines)
	 */
	public List<Double> getLineCor() {
		return lineCor;
	}
	
	/**
	 * @return the coordinates of all of the circle stamps
	 */
	public List<Double> getCircleStamps() {
		return circleStamps;
	}
	
	/**
	 * @return the coordinates of all of the square stamps
	 */
	public List<Double> getSquareStamps() {
		return squareStamps;
	}
	
	/**
	 * @return the coordinates of all of the triangle stamps
	 */
	public List<Double> getTriangleStamps() {
		return triangleStamps;
	}
	
	/**
	 * default indices are 1 - black, 2 - red, 3 - green, 4 - blue, 5 - white
	 * @return the index of the defined list of colors that the current pen color is set to
	 */
	
	public int getPenColor() {
		return penColor;
	}
	
	/**
	 * should never happen though...
	 * @return error message for if a illegal parameter is passed
	 */
	public String getError() {
		String errorMessage = new String(error);
		myTurtle.resetError();
		return error;
	}
}
