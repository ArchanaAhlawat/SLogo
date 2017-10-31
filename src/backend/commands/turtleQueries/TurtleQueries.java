package backend.commands.turtleQueries;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

/**
 * TurtleQueries class
 * Most queries do not need any commmands and just get the needed value and add that to the stack
 * @author kelly
 * 
 */
public abstract class TurtleQueries extends GeneralCommands {

	public TurtleQueries(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	protected void setParams() {
		//do nothing
	}
}