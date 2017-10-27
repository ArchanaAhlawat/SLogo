package backend.api;

import backend.Stacks;
import backend.Turtle;

public abstract class BooleanOperation extends GeneralCommands {

	protected static final double ZERO = 0.0;
	protected static final double ONE = 1.0;
	
	public BooleanOperation(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}
}
