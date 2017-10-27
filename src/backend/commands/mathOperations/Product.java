package backend.commands.mathOperations;

import backend.Stacks;
import backend.Turtle;
import backend.api.MathOperations;

/**
 * has the execute for when a product command is called
 *     pops the two parameter in the stack
 *     pushes their product onto the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class Product extends MathOperations {

	public Product(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		return expr1*expr2;
	}
}
