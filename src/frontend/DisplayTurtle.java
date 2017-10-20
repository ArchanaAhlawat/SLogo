package frontend;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javafx.scene.image.ImageView;

public class DisplayTurtle {
	private static final String XCOR = "xCor";
	private static final String YCOR = "yCor";
	private static final String HEADING = "heading";
	private static final String VISIBILITY = "visibility";
	private static final HashMap<String,Integer> UPDATEINDICES = new HashMap<String,Integer>() {{
		put(XCOR,0);
		put(YCOR,1);
		put(HEADING,2);
		put(VISIBILITY,3);
	}};
	private ImageView myTurtle;
	
	public DisplayTurtle(ImageView turtle, double originX, double originY) {
		myTurtle = turtle;
		myTurtle.setX(originX);
		myTurtle.setY(originY);
	}
	
	protected ImageView getTurtleImage() {
		return myTurtle;
	}
	
	protected void updateTurtle(List<Double> turtleUpdates) {
		myTurtle.setX(turtleUpdates.get(getUpdateIndex(XCOR)));
		myTurtle.setY(turtleUpdates.get(getUpdateIndex(YCOR)));
		myTurtle.setRotate(turtleUpdates.get(getUpdateIndex(HEADING)));
		myTurtle.setVisible(booleanConverter(turtleUpdates.get(getUpdateIndex(VISIBILITY))));
	}
	
	private int getUpdateIndex(String update) {
		return UPDATEINDICES.get(update);
	}
	
	private boolean booleanConverter(double dub) {
		return (dub == 1) ? true:false;
	}

}
