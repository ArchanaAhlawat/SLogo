package backend.commands.mathOperations;

import backend.Stacks;
import backend.Turtle;
import backend.api.MathOperations;

public class Sum extends MathOperations {
	
	public Sum(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		return expr1+expr2;
	}
}

