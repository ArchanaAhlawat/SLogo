package backend.commands.mathOperations;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;

/**
 * has the execute for when a quotient command is called
 *     pops the two parameter in the stack
 *     pushes their quotient onto the stack
 *
 * @author kelly
 *
 */
public class Quotient extends MathOperations {

	public Quotient(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		return expr1/expr2;
	}
}
