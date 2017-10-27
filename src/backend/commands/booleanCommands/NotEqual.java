package backend.commands.booleanCommands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;
import backend.api.BooleanOperation;

/**
 * has the execute for when a notequal command is called
 *     pops two parameters off the stack
 *     pushes if the first one is not equal to the second onto the stack
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class NotEqual extends BooleanOperation {

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
