package backend.commands.booleanOperations;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a and command is called
 *     pops two parameters off the stack
 *     pushes if both are nonzero onto the stack
 * 
 * @author kelly
 *
 */
public class And extends BooleanOperations {

	public And(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		if (expr1 != ZERO && expr2 != ZERO) {
			return ONE;
		}
		else {
			return ZERO;
		}
	}
}
