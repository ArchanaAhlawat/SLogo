package backend.commands.booleanOperations;

import backend.Stacks;
import backend.Turtle;

/**
 * has the execute for when a greaterthan command is called
 *     pops two parameters off the stack
 *     pushes if the first one is greater than the second onto the stack
 * 
 * @author kelly
 *
 */
public class GreaterThan extends BooleanOperations {

	public GreaterThan(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		if (expr1 > expr2) {
			return ONE;
		}
		else {
			return ZERO;
		}
	}
}
