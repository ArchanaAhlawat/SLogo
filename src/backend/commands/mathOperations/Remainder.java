package backend.commands.mathOperations;

import backend.Stacks;
import backend.Turtle;

/**
 * has the execute for when a remainder command is called
 *     pops the two parameter in the stack
 *     pushes the remainder of their division onto the stack
 *
 * @author kelly
 *
 */
public class Remainder extends MathOperations {

	public Remainder(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		return expr1 % expr2;
	}
}
