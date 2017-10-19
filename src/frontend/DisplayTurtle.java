package frontend;

import javafx.scene.image.ImageView;

public class DisplayTurtle {
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
