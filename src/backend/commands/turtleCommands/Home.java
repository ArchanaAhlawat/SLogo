package backend.commands.turtleCommands;

import backend.Stacks;
import backend.Turtle;
import backend.commands.TurtleCommands;

/**
 * has the execute for when a home command is called
 *     does not need any parameters from the stack
 *     moves the turtle to home (0,0)
 *     pushes the distance moved by the turtle to the stack
 * 	   returns the stack of parameters
 * 
 * @author kelly
 * 
 */
public class Home extends TurtleCommands {
	
	public Home(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	protected void setParams() {
		//do nothing
	}

	@Override
	protected double doUpdate() {
		return currentTurtle.home();
	}
}