package frontend;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javafx.scene.image.Image;

public class TurtleManager {
	
	private List<DisplayTurtle> activeTurtles;
	private List<DisplayTurtle> turtles;

	public TurtleManager(DisplayTurtle firstTurtle) {
		firstTurtle.setOnMouseClicked(e -> firstTurtle.changeTurtleActivity(activeTurtles));
		activeTurtles = new LinkedList<DisplayTurtle>(Arrays.asList(firstTurtle));
		turtles = new LinkedList<DisplayTurtle>(Arrays.asList(firstTurtle));
	}
	
	protected void createNewTurtle() {
		int largestID = turtles.size();
		DisplayTurtle newTurtle = new DisplayTurtle(largestID + 1);
		newTurtle.setOnMouseClicked(e -> newTurtle.changeTurtleActivity(activeTurtles));
		activeTurtles.add(newTurtle);
		turtles.add(newTurtle);
	}
	
	protected void updateTurtles(double xCor,double yCor,double theta,double turtleVis) {
		if(!activeTurtles.isEmpty()) {
			for(DisplayTurtle displayTurtle : activeTurtles) {
				displayTurtle.updateTurtle(xCor, yCor, theta, turtleVis);
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
