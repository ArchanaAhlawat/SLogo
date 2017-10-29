package frontend;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import backend.Turtle;
import javafx.scene.image.Image;
import javafx.scene.shape.Path;

public class DisplayTurtleManager {
	
	public static final double ORIGIN_X = FrontEndDriver.ORIGIN_X;
	public static final double ORIGIN_Y = FrontEndDriver.ORIGIN_Y;
	
	private HashMap<Integer,DisplayTurtle> activeTurtles;

	public DisplayTurtleManager(DisplayTurtle firstTurtle) {
		firstTurtle.setOnMouseClicked(e -> firstTurtle.activate());
		activeTurtles = new HashMap<Integer,DisplayTurtle>();
		activeTurtles.put(1, firstTurtle);
	}
	
	protected void updateTurtles(List<Turtle> turtles) {
		for(Turtle turtle : turtles) {
			int turtleID = turtle.getID();
			double updatedXCor = turtle.getX() + ORIGIN_X;
			double updatedYCor = turtle.getY() + ORIGIN_Y;
			double updatedTheta = turtle.getTheta();
			double updatedTurtleVis = turtle.getTurtleVis();
			if(activeTurtles.keySet().contains(turtleID)) {
				DisplayTurtle oldTurtle = activeTurtles.get(turtleID);
				oldTurtle.updateTurtle(updatedXCor, updatedYCor, updatedTheta, updatedTurtleVis);
			}
			else {
				DisplayTurtle newDisplayTurtle = new DisplayTurtle();
				activeTurtles.put(turtle.getID(),newDisplayTurtle.updateTurtle(updatedXCor, updatedYCor, updatedTheta, updatedTurtleVis);
			}
		}
	}
	
	protected void drawLines(List<Turtle> turtles) {
		for(Turtle turtle : turtles) {
			int turtleID = turtle.getID();
			Path turtlePath = turtle.getPath();
			activeTurtles.put(turtleID, turtlePath);
		}
	}
	
	protected void setImages(Image image) {
		if(!activeTurtles.isEmpty()) {
			for(DisplayTurtle displayTurtle : activeTurtles.values()) {
				displayTurtle.setImage(image);
			}
		}
	}
	
}
