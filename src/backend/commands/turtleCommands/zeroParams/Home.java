package backend.commands.turtleCommands.zeroParams;

import backend.Stacks;
import backend.Turtle;
import backend.commands.turtleCommands.TurtleCommands;

/**
 * has the execute for when a home command is called
 *     does not need any parameters from the stack
 *     moves the turtle to home (0,0)
 *     pushes the distance moved by the turtle to the stack
 * 
 * @author kelly
 * 
 */
public class Home extends TurtleCommands {
	
	public Home(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	protected double doUpdate() {
		return currentTurtle.home();
	}
}