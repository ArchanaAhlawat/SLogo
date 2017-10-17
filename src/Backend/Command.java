package Backend;

public interface Command {

	public TurtleInfo forward(double pixels);
	
	public TurtleInfo back(double pixels);
	
	public TurtleInfo left(double degrees);

	public TurtleInfo right(double degrees);
	
	public TurtleInfo setHeading(double degrees);

	public TurtleInfo setXY(double[] xy);
	
	public TurtleInfo penDown();

	public TurtleInfo penUp();

	public TurtleInfo showTurtle();

	public TurtleInfo hideTurtle();

	public TurtleInfo home();

	public TurtleInfo clearScreen();
	
}
