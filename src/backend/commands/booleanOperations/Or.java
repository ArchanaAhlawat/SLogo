package backend.commands.booleanOperations;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;

/**
 * has the execute for when a or command is called
 *     pops two parameters off the stack
 *     pushes if either the first or second are nonzero onto the stack
 * 
 * @author kelly
 *
 */
public class Or extends BooleanOperations {

	public Or(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		if (expr1 != ZERO || expr2 != ZERO) {
			return ONE;
		}
		else {
			return ZERO;
		}
	}
}
