package backend.commands.mathOperations;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;

/**
 * has the execute for when a sum command is called
 *     pops two parameters off the stack
 *     pushes the sum of this onto the stack
 * 
 * @author kelly
 *
 */
public class Sum extends MathOperations {
	
	public Sum(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		return expr1+expr2;
	}
}

