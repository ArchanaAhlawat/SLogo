package backend;

public interface Commands {
	
	public double forward(double pixels);

	public double back(double pixels);

	public double left(double degrees);

	public double right(double degrees);

	public double setHeading(double degrees);

	public double setXY(double[] xy);

	public int penDown();

	public int penUp();

	public int showTurtle();

	public int hideTurtle();

	public double home();

	public double clearScreen();

}
