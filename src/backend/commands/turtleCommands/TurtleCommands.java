package backend.commands.turtleCommands;

import backend.Stacks;
import backend.Turtle;
import backend.commands.GeneralCommands;

/**
 * Default for the commands with zero parameters needed
 * 
 * @author kelly
 *
 */
public abstract class TurtleCommands extends GeneralCommands {
	
	public TurtleCommands(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	protected void setParams() {
		//do nothing
	}
}
