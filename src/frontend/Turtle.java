package frontend;

import javafx.scene.image.ImageView;

/**
 * This class is the original backend class I wrote for turtle--can be ignored for now! The real front end turtle class is called "DisplayTurtle"
 * @author Owen Smith
 *
 */
public class Turtle {
	public static final double[] ORIGIN = new double[] {0,0};
	
	private ImageView myTurtle;
	private double[] turtleCoords;
	
	public Turtle(ImageView image) {
		myTurtle = image;
		setTurtleLoc(ORIGIN);
		turtleCoords = new double[] {myTurtle.getX(),myTurtle.getY()};
	}
	
	//Turtle queries------------------
	protected double heading() {
		return myTurtle.getRotate();
	}
	
	protected double xCor() {
		return myTurtle.getX();
	}
	
	protected double yCor() {
		return myTurtle.getY();
	}
	
	protected int showing() {
		return myTurtle.isVisible() ? 1 : 0;
	}
	
	//---------------------------------
	
	//Turtle commands------------------------------
	
	protected double forward(double distance) {
		double[] nPoint = VectorCalc.nPoint(turtleCoords, distance, myTurtle.getRotate(),true);
		setTurtleLoc(nPoint);
		return distance;
	}
	
	protected double back(double distance) {
		double[] nPoint = VectorCalc.nPoint(turtleCoords, distance, myTurtle.getRotate(),false);
		setTurtleLoc(nPoint);
		return distance;
	}
	
	protected double setHeading(double degrees) {
		double curHeading = myTurtle.getRotate();
		myTurtle.setRotate(degrees);
		return degrees - curHeading;
	}
	
	protected double setXY(double[] newCoords) {
		setTurtleLoc(newCoords);
		return VectorCalc.distance(newCoords,turtleCoords);
	}
	
	protected double left(double degrees) {
		myTurtle.setRotate(myTurtle.getRotate() - degrees);
		return degrees;
	}
	
	protected double right(double degrees) {
		myTurtle.setRotate(myTurtle.getRotate() + degrees);
		return degrees;
	}
	
	protected double hideTurtle() {
		myTurtle.setVisible(false);
		return 0;
	}
	
	protected double showTurtle() {
		myTurtle.setVisible(true);
		return 1;
	}
	
	protected double home() {
		setTurtleLoc(ORIGIN);
		return Math.sqrt(turtleCoords[0]*turtleCoords[0] + turtleCoords[1] * turtleCoords[1]);
	}
	
	//---------------------------------------------------
	
	// Useful turtle tools-----------------------------------------
	
	private void setTurtleLoc(double[] newCoords) {
		myTurtle.setX(newCoords[0]);
		myTurtle.setY(newCoords[1]);
		turtleCoords[0] = newCoords[0];
		turtleCoords[1] = newCoords[1];
	}
}
