package backend.api;

import backend.Stacks;
import backend.Turtle;

public abstract class MathOperations extends GeneralCommands {

	protected static final double RADTODEG = 180.0/Math.PI;
	protected static final double DEGTORAD = Math.PI/180.0;
	
	public MathOperations(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}
}
