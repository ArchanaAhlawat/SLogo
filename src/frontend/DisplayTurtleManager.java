package frontend;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import backend.Turtle;
import backend.Updates;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class DisplayTurtleManager {
	
	public static final double ORIGIN_X = FrontEndDriver.ORIGIN_X;
	public static final double ORIGIN_Y = FrontEndDriver.ORIGIN_Y;
	
	private static final int FIRST_TURTLE_ID = 1;
	
	private HashMap<Integer,DisplayTurtle> activeDisplayTurtles;
	private HashMap<Integer,DisplayTurtle> allDisplayTurtles;
	private List<DisplayTurtle> newlyAddedDisplayTurtles;

	public DisplayTurtleManager(DisplayTurtle firstDisplayTurtle) {
		activeDisplayTurtles = new HashMap<Integer,DisplayTurtle>();
		allDisplayTurtles = new HashMap<Integer,DisplayTurtle>();
		newlyAddedDisplayTurtles = new LinkedList<DisplayTurtle>();
		activeDisplayTurtles.put(FIRST_TURTLE_ID, firstDisplayTurtle);
		allDisplayTurtles.put(FIRST_TURTLE_ID, firstDisplayTurtle);
		firstDisplayTurtle.setOnMouseClicked(e -> activate(FIRST_TURTLE_ID));
	}
	
	protected void updateTurtles(List<Turtle> turtles,Display turtleArea) {
		newlyAddedDisplayTurtles.clear();
		for(Turtle turtle : turtles) {
			int turtleID = (int)turtle.getActiveTurtleID();
			Updates turtleUpdate = new Updates(turtle);
			double updatedXCor = turtleUpdate.getXCor() + ORIGIN_X;
			double updatedYCor = turtleUpdate.getYCor() + ORIGIN_Y;
			double updatedTheta = turtleUpdate.getTheta();
			double updatedTurtleVis = turtleUpdate.getTurtleVis();
			List<Double> updatedTurtleLines = turtle.getLines();
			if(activeDisplayTurtles.containsKey(turtleID)) {
				DisplayTurtle oldDisplayTurtle = activeDisplayTurtles.get(turtleID);
				oldDisplayTurtle.updateTurtle(updatedXCor, updatedYCor, updatedTheta, updatedTurtleVis,updatedTurtleLines);
			}
			else if(!allDisplayTurtles.containsKey(turtleID)){
				DisplayTurtle newDisplayTurtle = new DisplayTurtle(turtleID);
				newDisplayTurtle.updateTurtle(updatedXCor, updatedYCor, updatedTheta, updatedTurtleVis,updatedTurtleLines);
				newDisplayTurtle.setOnMouseClicked(e -> activate(newDisplayTurtle.getID()));
				activeDisplayTurtles.put((int)turtle.getActiveTurtleID(),newDisplayTurtle);
				newlyAddedDisplayTurtles.add(newDisplayTurtle);
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
		return activeDisplayTurtles.get(FIRST_TURTLE_ID);
	}
	
	protected void activate(int turtleID) {
		DisplayTurtle displayTurtle = allDisplayTurtles.get(turtleID);
		if(!activeDisplayTurtles.containsKey(turtleID)) {
			activeDisplayTurtles.put(turtleID, displayTurtle);
			displayTurtle.activateTransparent();
			displayTurtle.setActive(true);
		}
		else {
			activeDisplayTurtles.remove(turtleID);
			displayTurtle.activateShadow();
			displayTurtle.setActive(false);
		}
	}
	
	protected void updateTurtlePathColors(Color color) {
		for(DisplayTurtle activeDisplayTurtle : activeDisplayTurtles.values()) {
			activeDisplayTurtle.updateTurtlePathColor(color);
		}
	}
	
	protected List<DisplayTurtle> getNewlyAddedDisplayTurtles() {
		return newlyAddedDisplayTurtles;
	}

}
