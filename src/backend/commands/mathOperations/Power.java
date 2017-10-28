package backend.commands.mathOperations;

import backend.Stacks;
import backend.Turtle;
import backend.commands.MathOperations;

/**
 * has the execute for when a power command is called
 *     pops two parameters off the stack, the base and the exponent
 *     pushes the value of the base to the exponent onto the stack
 * 
 * @author kelly
 *
 */
public class Power extends MathOperations {

	public Power(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		return Math.pow(expr1,expr2);
	}
}
