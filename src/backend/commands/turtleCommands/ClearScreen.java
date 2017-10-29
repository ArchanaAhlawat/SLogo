package backend.commands.turtleCommands;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;

/**
 * has the execute for when a clearscreen command is called
 *     does not need any parameters from the stack
 *     moves the turtle to home and clears all of the trails
 *     pushes the distance moved by the turtle to the stack
 * 
 *  @author kelly
 * 
 */
public class ClearScreen extends TurtleCommands {
	
	public ClearScreen(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	protected double doUpdate() {
		return currentTurtle.clearScreen();
	}
}