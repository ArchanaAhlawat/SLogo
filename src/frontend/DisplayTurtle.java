package frontend;

import javafx.scene.image.ImageView;

public class DisplayTurtle {

	public static final double ORIGIN_X = 0;	//might change later if we change the configuration of the grid
	public static final double ORIGIN_Y = 0;	//might change later if we change the configuration of the grid
	private ImageView myTurtle;
	
	public DisplayTurtle(ImageView turtle) {
		myTurtle = turtle;
		myTurtle.setX(ORIGIN_X);
		myTurtle.setY(ORIGIN_Y);

	private ImageView myTurtle;
	
	public DisplayTurtle(ImageView turtle, double originX, double originY) {
		myTurtle = turtle;
		myTurtle.setX(originX);
		myTurtle.setY(originY);
	}
	
	protected void updateTurtle(Turtle turtle) {
		myTurtle.setX(turtle.getX());
		myTurtle.setY(turtle.getY());
		myTurtle.setRotattion(turtle.getRotation());
		myTurtle.setVisible(turtle.isVisible());

	}

}
