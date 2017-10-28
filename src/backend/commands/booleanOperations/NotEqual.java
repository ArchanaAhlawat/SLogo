package backend.commands.booleanOperations;

import backend.Stacks;
import backend.Turtle;

/**
 * has the execute for when a notequal command is called
 *     pops two parameters off the stack
 *     pushes if the first one is not equal to the second onto the stack
 * 
 * @author kelly
 *
 */
public class NotEqual extends BooleanOperations {

	public NotEqual(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		if (expr1 != expr2) {
			return ONE;
		}
		else {
			return ZERO;
		}
	}
}
