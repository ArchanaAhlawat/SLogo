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
	private List<Double> lineCor;
	private double penColor;
	
	public Updates(TurtleTree myTurtle) { // ONE TURTLE ONLY
		xcor = myTurtle.getAbsoluteOrientation(XCOR)[0];
		System.out.println("updated Turtle xCor from Updates: " + xcor);
		ycor = myTurtle.getAbsoluteOrientation(YCOR)[0];
		theta = myTurtle.getAbsoluteOrientation(THETA)[0];
		penDown = myTurtle.getAbsoluteOrientation(PENDOWN)[0];
		turtleVis = myTurtle.getAbsoluteOrientation(TURTLEVIS)[0];
		lineCor = myTurtle.getLines();
		penColor = myTurtle.getPenColor();
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
	
	public double getPenColor() {
		return penColor;
	}
}
