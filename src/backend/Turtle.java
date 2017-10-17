package backend;

public class Turtle implements Commands {

	private double xcor, ycor, theta;
	// xcor=0, ycor=0 is in center
	// xcor increases to the right, ycor increases down
	// theta = 0 is pointed north (up)
	// theta is in degrees 0 to 360 going clockwise
	private boolean penDown, turtleVis;
	
	private static final double zero = 0.0;
	

	public Turtle() {
		xcor = ycor = theta = zero;
		penDown = turtleVis = true;
	}
	
	public Turtle(double x, double y, double r, boolean penDown, boolean turtleVis) {
		this.xcor = x;
		this.ycor = y;
		this.theta = r;
		this.penDown = penDown;
		this.turtleVis = turtleVis;
	}

	//TODO: getters and setters need to be wrapped 
//	public double getx() {
//		return x;
//	}
//	public double gety() {
//		return y;
//	}
//	public double getr() {
//		return r;
//	}
//
//	public boolean getPenDown() {
//		return penDown;
//	}
//	public boolean getTurtleVis() {
//		return turtleVis;
//	}

	@Override
	public Turtle forward(double pixels) {
		return new Turtle(this.xcor + pixels*Math.sin(this.theta/360),
				this.ycor - pixels*Math.cos(this.theta/360),
				this.theta,
				this.penDown,
				this.turtleVis);
	}

	@Override
	public Turtle back(double pixels) {
		return new Turtle(this.xcor - pixels*Math.sin(this.theta/360),
				this.ycor + pixels*Math.cos(this.theta/360),
				this.theta,
				this.penDown,
				this.turtleVis);
	}

	@Override
	public Turtle left(double degrees) {
		return new Turtle(this.xcor,
				this.ycor,
				this.theta - degrees,
				this.penDown,
				this.turtleVis);
	}

	@Override
	public Turtle right(double degrees) {
		return new Turtle(this.xcor,
				this.ycor,
				this.theta + degrees,
				this.penDown,
				this.turtleVis);
	}

	@Override
	public Turtle setHeading(double degrees) {
		return new Turtle(this.xcor,
				this.ycor,
				degrees,
				this.penDown,
				this.turtleVis);
	}

	@Override
	public Turtle setXY(double[] xy) {
		return new Turtle(xy[0],
				xy[1],
				this.theta,
				this.penDown,
				this.turtleVis);
	}

	@Override
	public Turtle penDown() {
		return new Turtle(this.xcor,
				this.ycor,
				this.theta,
				true,
				this.turtleVis);
	}

	@Override
	public Turtle penUp() {
		return new Turtle(this.xcor,
				this.ycor,
				this.theta,
				false,
				this.turtleVis);
	}

	@Override
	public Turtle showTurtle() {
		return new Turtle(this.xcor,
				this.ycor,
				this.theta,
				this.penDown,
				true);
	}

	@Override
	public Turtle hideTurtle() {
		return new Turtle(this.xcor,
				this.ycor,
				this.theta,
				this.penDown,
				false);
	}

	@Override
	public Turtle home() {
		return new Turtle(zero,
				zero,
				this.theta,
				this.penDown,
				true);
	}

	@Override
	public Turtle clearScreen() {
		// TODO Auto-generated method stub
		return null;
	}
}
