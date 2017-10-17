package backend;

public interface Commands {
	
	public Turtle forward(double pixels);

	public Turtle back(double pixels);

	public Turtle left(double degrees);

	public Turtle right(double degrees);

	public Turtle setHeading(double degrees);

	public Turtle setXY(double[] xy);

	public Turtle penDown();

	public Turtle penUp();

	public Turtle showTurtle();

	public Turtle hideTurtle();

	public Turtle home();

	public Turtle clearScreen();

}
