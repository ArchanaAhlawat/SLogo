package backend.commands.booleanOperations;

import backend.Stacks;
import backend.Turtle;

/**
 * has the execute for when a lessthan command is called
 *     pops two parameters off the stack
 *     pushes if the first one is less than the second onto the stack
 * 
 * @author kelly
 *
 */
public class LessThan extends BooleanOperations {

	public LessThan(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		if (expr1 < expr2) {
			return ONE;
		}
		else {
			return ZERO;
		}
	}
}
