package frontend;

import javafx.scene.image.ImageView;

public class Turtle {
	public static final double ORIGIN_X = 0;
	public static final double ORIGIN_Y = 0;
	
	private ImageView myTurtle;
	
	public Turtle(ImageView image) {
		myTurtle = image;
		myTurtle.setX(ORIGIN_X);
		myTurtle.setY(ORIGIN_Y);
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
	
	//---------------------------------
	
	//Turtle commands------------------------------
	
	protected double setHeading(double degrees) {
		double curHeading = myTurtle.getRotate();
		myTurtle.setRotate(degrees);
		return degrees - curHeading;
	}
	
	protected double setXY(double x,double y) {
		double curX = myTurtle.getX();
		double curY = myTurtle.getY();
		myTurtle.setX(x);
		myTurtle.setY(y);
		return Math.sqrt((x - curX)*(x - curX) + (y - curY)*(y - curY));
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
		double curX = myTurtle.getX();
		double curY = myTurtle.getY();
		myTurtle.setX(ORIGIN_X);
		myTurtle.setY(ORIGIN_Y);
		return Math.sqrt(curX*curX + curY * curY);
	}
	
	//---------------------------------------------------
}
