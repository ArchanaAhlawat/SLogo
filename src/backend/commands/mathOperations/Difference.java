package backend.commands.mathOperations;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;

/**
 * has the execute for when a difference command is called
 *     pops the two parameter from the stack
 *     pushes their sum onto the stack
 *
 * @author kelly
 * 
 */
public class Difference extends MathOperations {

	public Difference(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		return expr1-expr2;
	}
}
