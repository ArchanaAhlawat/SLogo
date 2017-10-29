package frontend;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import backend.Turtle;
import javafx.scene.image.Image;

public class DisplayTurtleManager {
	
	private HashMap<Integer,DisplayTurtle> activeTurtles;

	public DisplayTurtleManager(DisplayTurtle firstTurtle) {
		firstTurtle.setOnMouseClicked(e -> firstTurtle.activate());
		activeTurtles = new HashMap<Integer,DisplayTurtle>();
		activeTurtles.put(1, firstTurtle);
	}
	
	protected void createNewTurtle() {
		int largestID = turtles.size();
		DisplayTurtle newTurtle = new DisplayTurtle(largestID + 1);
		newTurtle.setOnMouseClicked(e -> newTurtle.changeTurtleActivity(activeTurtles));
		activeTurtles.add(newTurtle);
		turtles.add(newTurtle);
	}
	
	protected void updateTurtles(List<Turtle> turtles) {
		for(Turtle turtle : turtles) {
			int turtleID = turtle.getActiveTurtleID();
		}
	}
	
	protected void drawLines(List<Double> linesToDraw) {
		if(!activeTurtles.isEmpty()) {
			for(DisplayTurtle displayTurtle : activeTurtles) {
				displayTurtle.drawPath(linesToDraw);
			}
		}
	}
	
	protected void setImages(Image image) {
		if(!activeTurtles.isEmpty()) {
			for(DisplayTurtle displayTurtle : activeTurtles) {
				displayTurtle.setImage(image);
			}
		}
	}
	
	protected int getActiveTurtleID() {
		if(!activeTurtles.isEmpty()) {
			return getActiveTurtle().getID();
		}
		else {
			return 0;
		}
	}
	
	protected DisplayTurtle getActiveTurtle() {
		if(!activeTurtles.isEmpty()) {
			int numActiveTurtles = activeTurtles.size();
			return activeTurtles.get(numActiveTurtles - 1);
		}
		else return null;
	}
	
}
