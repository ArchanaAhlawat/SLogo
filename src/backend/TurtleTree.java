package backend;

import java.util.List;

import javafx.scene.paint.Color;

public interface TurtleTree {
	public static final int DEGREESINCIRCLE = 360;
	public static final int NEGATE = -1;
	public static final double ZERO = 0.0;
	public static final double HALF = 0.5;
	public static final double ONE = 1.0;
	public static final double DEGTORAD = Math.PI/180.0;
	public static final double RADTODEG = 180/Math.PI;
	
	public static final int[] BLACK = new int[] {0,0,0};
	public static final int[] RED = new int[] {255,0,0};
	public static final int[] GREEN = new int[] {0,255,0};
	public static final int[] BLUE = new int[] {0,0,255};
	public static final int[] WHITE = new int[] {255,255,255};
	public static final int[][] COLORS = new int[][] {new int[] {0}, BLACK, RED, GREEN, BLUE, WHITE};
	
	public double xcor = 0;
	public double ycor = 0;
	public double theta = 0;
	public double penDown = 0;
	public double turtleVis = 0;
	public List<Double> lineCor = null;
	public List<Color> lineColor = null;
	public List<Double> lineThickness = null;

	public double xDisplacement(double x);

	public double yDisplacement(double y);

	public double distance(double x, double y);
	
	public double[] angle(double x, double y);
	
	public void reactivateTurtle(double num);
	
	public double[] getAbsoluteOrientation(String orientation);
	
	public List<Double> getLines();
	
	public void move(double pixels);
	
	public void rotate(double degrees);
	
	public double setHeading(double[] expr1);
	
	public double setXY(double x, double y);
	
	public double penChange(double change);
	
	public double visChange(double change);
	
	public double home();
	
	public double clearScreen();
	
	public void addTurtle();
	
	public void addTurtle(double num);
	
	public void removeTurtle(double num);
	
	public double getSize();
	
	public int[] getPenColor();
	
	public double getActiveTurtleID();
	
	public void setActiveTurtles();
	
	public void addActiveTurtle();
	
	public void addActiveTurtle(double num);
	
	public void createTurtles(int num);
	
	public boolean containsID(double num);
	
	public void activateTurtle(double ID);
	
	public void clearActiveTurtles();

	public void deactivateTurtle(double id);

	public List<Turtle> getActiveTurtles();
}
