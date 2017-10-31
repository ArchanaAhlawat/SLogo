package backend.commands.turtleCommands;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

/**
 * TurtcleCommands class
 * Default for the commands with zero parameters needed
 * does not pop/peek any parameters, does the update and then returns the value and adds it to teh stack
 * @author kelly
 *
 */
public abstract class TurtleCommands extends GeneralCommands {
	
	public TurtleCommands(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	protected void setParams() {
		//do nothing
	}
}
