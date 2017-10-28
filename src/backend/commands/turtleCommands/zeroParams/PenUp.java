package backend.commands.turtleCommands.zeroParams;

import backend.Stacks;
import backend.Turtle;
import backend.commands.turtleCommands.TurtleCommands;

/**
 * has the execute for when a penup command is called
 *     doesn't need any input parameters from the stack
 *     sets the pen to up and doesn't track any trails for the pen
 *     pushes the return value from the penup command (0) to the stack
 * 
 *  @author kelly
 * 
 */
public class PenUp extends TurtleCommands {
	
	public PenUp(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		return currentTurtle.penChange(ZERO);
	}
}