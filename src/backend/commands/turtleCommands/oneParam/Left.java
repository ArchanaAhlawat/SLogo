package backend.commands.turtleCommands.oneParam;

import backend.Stacks;
import backend.Turtle;
import backend.commands.turtleCommands.TurtleCommandsOneParam;

/**
 * has the execute for when a left command is called
 *     peeks at the first value in the stack (parameter of degrees to turn left)
 *     rotates the turtle left by that number of degrees
 *     doesn't need to push anything to the stack bc the parameter returned is what was peeked (not popped!)
 * 	   returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class Left extends TurtleCommandsOneParam {
	
	public Left(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	protected double doUpdate() {
		currentTurtle.rotate(-1*expr1);
		return expr1;
	}
}