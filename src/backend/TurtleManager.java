package backend;

import java.util.ArrayList;
import java.util.List;

public class TurtleManager implements TurtleTree {
	protected List<Turtle> allTurtles = new ArrayList<Turtle>();
	protected List<Turtle> activeTurtles = new ArrayList<Turtle>();
	protected double turtleCount = 0;
	protected int turtleID;
	private List<Double> activeIDs = new ArrayList<Double>();
	
	public TurtleManager() {
		this.addActiveTurtle();
	}
	
	@Override
	public double xDisplacement(double x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double yDisplacement(double y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double distance(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double angle(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAbsoluteOrientation(String orientation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Double> getLines() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void move(double pixels) {
		for (Turtle t : activeTurtles) {
			t.move(pixels);
		}
	}

	@Override
	public void rotate(double degrees) {
		for (Turtle t : activeTurtles) {
			t.rotate(degrees);
		}
	}

	@Override
	public double setHeading(double degrees) {
		double toReturn = 0;
		for (Turtle t : activeTurtles) {
			toReturn = t.setHeading(degrees);
		}
		return toReturn;
	}

	@Override
	public double setXY(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double penChange(double change) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double visChange(double change) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double home() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double clearScreen() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addActiveTurtle() {
		turtleCount++;
		Turtle t = new Turtle();
		t.setTurtleID(turtleCount);
		activeTurtles.add(t);
		activeIDs.add(turtleCount);
	}
	
	@Override
	public void addActiveTurtle(double num) {
		turtleCount++;
		Turtle t = new Turtle();
		t.setTurtleID(num);
		activeTurtles.add(t);
		activeIDs.add(num);
	}
	
	public void addActiveTurtle(Turtle t) {
		activeTurtles.add(t);
		activeIDs.add(t.turtleID);
	}
	
	@Override
	public void addTurtle() {
		turtleCount++;
		Turtle t = new Turtle();
		t.setTurtleID(turtleCount);
		allTurtles.add(t);
		//allIDs.add(turtleCount);
	}
	
	@Override
	public void addTurtle(double num) {
		turtleCount++;
		Turtle t = new Turtle();
		t.setTurtleID(num);
		activeTurtles.add(t);
		//allIDs.add(num);
	}

	@Override
	public void removeTurtle(double num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getSize() {
		return turtleCount;
	}

	@Override
	public double getActiveTurtleID() {
		return activeTurtles.get((int)turtleCount - 1).getActiveTurtleID();
	}

	@Override
	public void setActiveTurtles() {
		// TODO Auto-generated method stub
	}

	@Override
	public void createTurtles(int num) {
		for (double i = turtleCount; i < num; i++) {
			Turtle newTurtle = new Turtle();
			newTurtle.setTurtleID(i+1);
			activeTurtles.add(newTurtle);
		}
	}

	@Override
	public boolean containsID(double num) {
		return (activeIDs.contains(num));
	}

	@Override
	public void activateTurtle(double ID) {
		Turtle t = null;
		for (int i = 0; i < allTurtles.size(); i++) {
			if (allTurtles.get(i).turtleID == ID) {
				t = allTurtles.get(i);
			}
		}
		addActiveTurtle(t);
	}
	
	public void clearActiveTurtles() {
		activeTurtles.clear();
	}

}
