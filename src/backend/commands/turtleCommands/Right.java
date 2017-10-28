package backend.commands.turtleCommands;

import backend.Stacks;
import backend.Turtle;

/**
 * has the execute for when a right command is called
 *     peeks at the first value in the stack (parameter of degrees to turn right)
 *     rotates the turtle right by that number of degrees
 *     doesn't need to push anything to the stack bc the parameter returned is what was peeked (not popped!)
 *
 * @author kelly
 * 
 */
public class Right extends TurtleCommandsOneParam {
	
	public Right(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		currentTurtle.rotate(expr1);
		return expr1;
	}
}