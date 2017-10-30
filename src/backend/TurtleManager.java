package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author archana
 *
 */
public class TurtleManager implements TurtleTree {
	protected List<Turtle> allTurtles = new ArrayList<Turtle>();
	protected List<Turtle> activeTurtles = new ArrayList<Turtle>();
	protected ColorManager myColors = new ColorManager();
	protected double turtleCount = 0;
	protected int turtleID;
	private List<Double> allIDs = new ArrayList<Double>();
	private Map<Double, Turtle> IDTurtleMap = new HashMap<Double, Turtle>();
	
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
	public double[] angle(double x, double y) {
		double[] toReturn = new double[activeTurtles.size()];
		for (int i = 0; i < activeTurtles.size(); i++) {
			toReturn[i] = activeTurtles.get(i).angle(x, y)[0];
		}
		return toReturn;
	}

	@Override
	public double[] getAbsoluteOrientation(String orientation) {
		double[] toReturn = new double[activeTurtles.size()];
		for (int i = 0; i < activeTurtles.size(); i++) {
			toReturn[i] = activeTurtles.get(i).getAbsoluteOrientation(orientation)[0];
		}
		return toReturn;
	}

	@Override
	public List<Double> getLines() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Double> getCircleStamps() {
		List<Double> toReturn = new ArrayList<>();
		for (Turtle t : activeTurtles) {
			toReturn = t.getCircleStamps();
		}
		return toReturn;
	}

	@Override
	public List<Double> getSquareStamps() {
		List<Double> toReturn = new ArrayList<>();
		for (Turtle t : activeTurtles) {
			toReturn = t.getSquareStamps();
		}
		return toReturn;
	}

	@Override
	public List<Double> getTriangleStamps() {
		List<Double> toReturn = new ArrayList<>();
		for (Turtle t : activeTurtles) {
			toReturn = t.getTriangleStamps();
		}
		return toReturn;
	}
	
	@Override
	public double getPenColor() {
		// TODO Auto-generated method stub
		return 0.0;
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
	public double setHeading(double[] degrees) {
		double toReturn = 0;
		for (int i = 0; i < degrees.length; i++) {
			toReturn = activeTurtles.get(i).setHeading(new double[]{degrees[i]});
		}
		return toReturn;
		//return activeTurtles.get(0).setHeading(degrees);
	}

	@Override
	public double setXY(double x, double y) {
		double toReturn = 0;
		for (Turtle t : activeTurtles) {
			toReturn = t.setXY(x, y);
		}
		return toReturn;
	}

	public double stamp() {
		//do nothing
		return 0.0;
	}
	
	public double setPenColor(int index) {
		double toReturn = 0;
		for (Turtle t : activeTurtles) {
			toReturn = t.setPenColor(index);
		}
		return toReturn;
	}
	
	@Override
	public double setPenSize(double size) {
		// TODO Auto-generated method stub
		return size;
	}
	
	@Override
	public double penChange(double change) {
		double toReturn = 0;
		for (Turtle t : activeTurtles) {
			toReturn = t.penChange(change);
		}
		return toReturn;
	}
	
	@Override
	public void setColorIndex(int index, int[] newColor) {
		// TODO Auto-generated method stub
	}
	
	public ColorManager getColorManager() {
		return myColors;
	}

	@Override
	public double visChange(double change) {
		double toReturn = 0;
		for (Turtle t : activeTurtles) {
			toReturn = t.visChange(change);
		}
		return toReturn;
	}

	@Override
	public double home() {
		double toReturn = 0;
		for (Turtle t : activeTurtles) {
			toReturn = t.home();
		}
		return toReturn;
	}

	@Override
	public double clearScreen() {
		double toReturn = 0;
		for (Turtle t : activeTurtles) {
			toReturn = t.clearScreen();
		}
		return toReturn;
	}
	
	@Override
	public void clearStamps() {
		for (Turtle t : activeTurtles) {
			t.clearStamps();
		}
	}

	@Override
	public void addActiveTurtle() {
		turtleCount++;
		Turtle t = new Turtle();
		t.setTurtleID(turtleCount);
		activeTurtles.add(t);
		allTurtles.add(t);
		allIDs.add(turtleCount);
	}
	
	@Override
	public void addActiveTurtle(double num) { // used in Tell
		turtleCount++;
		Turtle t = new Turtle();
		t.setTurtleID(num);
		activeTurtles.add(t);
		allTurtles.add(t);
		allIDs.add(num);
	}
	
	public void reactivateTurtle(double num) {  // TODO 
		Turtle t = IDTurtleMap.get(num);
		addActiveTurtle(t);
	}
	
	public void addActiveTurtle(Turtle t) { // for internal use i think TODO
		activeTurtles.add(t);
		allTurtles.add(t);
		allIDs.add(t.turtleID);
	}
	
	@Override
	public void addTurtle() {
//		turtleCount++;
//		Turtle t = new Turtle();
//		t.setTurtleID(turtleCount);
//		allTurtles.add(t);
		//allIDs.add(turtleCount);
	}
	
	@Override
	public void addTurtle(double num) {
//		turtleCount++;
//		Turtle t = new Turtle();
//		t.setTurtleID(num);
//		activeTurtles.add(t);
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
		return activeTurtles.get(activeTurtles.size() - 1).getActiveTurtleID();
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
			allTurtles.add(newTurtle);
		}
	}

	@Override
	public boolean containsID(double num) {
		return (allIDs.contains(num));
	}

	@Override
	public void activateTurtle(double ID) { // USED IN TELL.
		Turtle t = null;
		for (int i = 0; i < allTurtles.size(); i++) {
			if (allTurtles.get(i).turtleID == ID) {
				t = allTurtles.get(i);
			}
		}
		addActiveTurtle(t);
	}
	
	@Override
	public void clearActiveTurtles() {
		activeTurtles.clear();
	}

	@Override
	public void deactivateTurtle(double id) {
		Turtle toRemove = IDTurtleMap.get(id);
		activeTurtles.remove(toRemove); // ALL TURTLES LIST SHOULD ALWAYS HAVE ALL TURTLES? 
	}

	@Override
	public List<Turtle> getActiveTurtles() { // uh this is bad bc mutable :o RIP
		return activeTurtles;
	}
}
