package backend;

import java.util.List;

public class Updates {
	private static final String XCOR = "xcor";
	private static final String YCOR = "ycor";
	private static final String THETA = "theta";
	private static final String PENDOWN = "penDown";
	private static final String TURTLEVIS = "turtleVis";	
	private double xcor, ycor, theta, penDown, turtleVis;
	private List<Double> lineCor;
	
	public Updates(Turtle myTurtle) {
		xcor = myTurtle.getAbsoluteOrientation(XCOR);
		ycor = myTurtle.getAbsoluteOrientation(YCOR);
		theta = myTurtle.getAbsoluteOrientation(THETA);
		penDown = myTurtle.getAbsoluteOrientation(PENDOWN);
		turtleVis = myTurtle.getAbsoluteOrientation(TURTLEVIS);
		lineCor = myTurtle.getLines();
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
	
	public List<Double> getLineCor() {
		return lineCor;
	}
}
