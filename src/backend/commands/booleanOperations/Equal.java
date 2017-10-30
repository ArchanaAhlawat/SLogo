package backend.commands.booleanOperations;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;

/**
 * has the execute for when a equal command is called
 *     pops two parameters off the stack
 *     pushes if the first one is equal to the second onto the stack
 * 
 * @author kelly
 *
 */
public class Equal extends BooleanOperations {

	public Equal(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		if (expr1 == expr2) {
			return ONE;
		}
		else {
			return ZERO;
		}
	}
}
