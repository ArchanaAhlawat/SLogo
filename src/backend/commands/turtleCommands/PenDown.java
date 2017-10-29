package backend.commands.turtleCommands;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;

/**
 * has the execute for when a pendown command is called
 *     doesn't need any input parameters from the stack
 *     sets the pen to down and tracks the trails drawn by the turtle in the next commands
 *     pushes the return value from the pendown command (1) to the stack
 * 
 * @author kelly
 * 
 */
public class PenDown extends TurtleCommands {
	
	public PenDown(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	protected double doUpdate() {
		return currentTurtle.penChange(ONE);
	}
}
