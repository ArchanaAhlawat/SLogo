package backend.commands.turtleCommands;

import backend.Stacks;
import backend.Turtle;

/**
 * has the execute for when a setposition command is called
 *     pops two parameters needed off the stack to be used to set the position
 *     makes the turtle move to that absolute location
 *     pushes the distance moved to the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class SetPosition extends TurtleCommandsTwoParams {
	
	public SetPosition(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		return currentTurtle.setXY(expr1, NEGATE*expr2);
	}
}