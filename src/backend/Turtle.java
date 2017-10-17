package backend;

public class Turtle implements Commands {

	private double x, y, r;
	// x=0, y=0 is in center
	// x increases to the right, y increases down
	// r = 0 is pointed north (up)
	// r is in degrees 0 to 360 going clockwise
	private boolean penDown, turtleVis;
	
	private static final double zero = 0.0;
	

	public Turtle() {
		x = y = r = zero;
		penDown = turtleVis = true;
	}
	
	public Turtle(double x, double y, double r, boolean penDown, boolean turtleVis) {
		this.x = x;
		this.y = y;
		this.r = r;
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
		return new Turtle(this.x + pixels*Math.sin(this.r/360),
				this.y - pixels*Math.cos(this.r/360),
				this.r,
				this.penDown,
				this.turtleVis);
	}

	@Override
	public Turtle back(double pixels) {
		return new Turtle(this.x - pixels*Math.sin(this.r/360),
				this.y + pixels*Math.cos(this.r/360),
				this.r,
				this.penDown,
				this.turtleVis);
	}

	@Override
	public Turtle left(double degrees) {
		return new Turtle(this.x,
				this.y,
				this.r - degrees,
				this.penDown,
				this.turtleVis);
	}

	@Override
	public Turtle right(double degrees) {
		return new Turtle(this.x,
				this.y,
				this.r + degrees,
				this.penDown,
				this.turtleVis);
	}

	@Override
	public Turtle setHeading(double degrees) {
		return new Turtle(this.x,
				this.y,
				degrees,
				this.penDown,
				this.turtleVis);
	}

	@Override
	public Turtle setXY(double[] xy) {
		return new Turtle(xy[0],
				xy[1],
				this.r,
				this.penDown,
				this.turtleVis);
	}

	@Override
	public Turtle penDown() {
		return new Turtle(this.x,
				this.y,
				this.r,
				true,
				this.turtleVis);
	}

	@Override
	public Turtle penUp() {
		return new Turtle(this.x,
				this.y,
				this.r,
				false,
				this.turtleVis);
	}

	@Override
	public Turtle showTurtle() {
		return new Turtle(this.x,
				this.y,
				this.r,
				this.penDown,
				true);
	}

	@Override
	public Turtle hideTurtle() {
		return new Turtle(this.x,
				this.y,
				this.r,
				this.penDown,
				false);
	}

	@Override
	public Turtle home() {
		return new Turtle(zero,
				zero,
				this.r,
				this.penDown,
				true);
	}

	@Override
	public Turtle clearScreen() {
		// TODO Auto-generated method stub
		return null;
	}
}
