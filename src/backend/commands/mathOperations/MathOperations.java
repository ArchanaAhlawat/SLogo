package backend.commands.mathOperations;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

/**
 * MathOperations class
 * Most math operations still take two parameters that need to be popped off the stack to do the update and the result returned to the stack
 * Some override the parameters to just peek the one value and do the update without needing to return the value to be added to the stack
 * Finally some override execute to pop one parameter and then do the update and return the value to the stack
 * @author kelly
 *
 */
public abstract class MathOperations extends GeneralCommands {

	protected static final double RADTODEG = 180.0/Math.PI;
	protected static final double DEGTORAD = Math.PI/180.0;
	
	public MathOperations(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
}
