package frontend;

import java.util.HashMap;
import java.util.List;
import backend.Turtle;
import backend.Updates;
import javafx.scene.image.Image;

public class DisplayTurtleManager {
	
	public static final double ORIGIN_X = FrontEndDriver.ORIGIN_X;
	public static final double ORIGIN_Y = FrontEndDriver.ORIGIN_Y;
	
	private static final int FIRST_TURTLE_ID = 1;
	
	private HashMap<Integer,DisplayTurtle> activeDisplayTurtles;
	private HashMap<Integer,DisplayTurtle> allDisplayTurtles;

	public DisplayTurtleManager(DisplayTurtle firstDisplayTurtle) {
		activeDisplayTurtles = new HashMap<Integer,DisplayTurtle>();
		allDisplayTurtles = new HashMap<Integer,DisplayTurtle>();
		activeDisplayTurtles.put(FIRST_TURTLE_ID, firstDisplayTurtle);
		allDisplayTurtles.put(FIRST_TURTLE_ID, firstDisplayTurtle);
		firstDisplayTurtle.setOnMouseClicked(e -> activate(FIRST_TURTLE_ID));
	}
	
	protected void updateTurtles(List<Turtle> turtles,Display turtleArea) {
		for(Turtle turtle : turtles) {
			int turtleID = (int)turtle.getActiveTurtleID();
			Updates turtleUpdate = new Updates(turtle);
			double updatedXCor = turtleUpdate.getXCor() + ORIGIN_X;
			double updatedYCor = turtleUpdate.getYCor() + ORIGIN_Y;
			double updatedTheta = turtleUpdate.getTheta();
			double updatedTurtleVis = turtleUpdate.getTurtleVis();
			if(activeDisplayTurtles.containsKey(turtleID)) {
				DisplayTurtle oldDisplayTurtle = activeDisplayTurtles.get(turtleID);
				oldDisplayTurtle.updateTurtle(updatedXCor, updatedYCor, updatedTheta, updatedTurtleVis,turtle.getLines());
			}
			else if(!allDisplayTurtles.containsKey(turtleID)){
				DisplayTurtle newDisplayTurtle = new DisplayTurtle();
				newDisplayTurtle.updateTurtle(updatedXCor, updatedYCor, updatedTheta, updatedTurtleVis,turtle.getLines());
				newDisplayTurtle.setOnMouseClicked(e -> activate(newDisplayTurtle.getID()));
				activeDisplayTurtles.put((int)turtle.getActiveTurtleID(),newDisplayTurtle);
				turtleArea.getChildren().addAll(newDisplayTurtle,newDisplayTurtle.getPath());
			}
		}
	}
	
	protected void setImages(Image image) {
		for(DisplayTurtle displayTurtle : activeDisplayTurtles.values()) {
			displayTurtle.setImage(image);
		}
	}
	
	protected DisplayTurtle getAnActiveTurtle() {
		return activeDisplayTurtles.get(1);
	}
	
	protected void activate(int turtleID) {
		DisplayTurtle displayTurtle = allDisplayTurtles.get(turtleID);
		if(!activeDisplayTurtles.containsKey(turtleID)) {
			activeDisplayTurtles.put(turtleID, displayTurtle);
			displayTurtle.activateTransparent();
		}
		else {
			activeDisplayTurtles.remove(turtleID);
			displayTurtle.activateShadow();
		}
	}
	
}
