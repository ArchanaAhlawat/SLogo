package backend.commands.turtleCommands;

import backend.Stacks;
import backend.Turtle;
import backend.commands.TurtleCommands;

/**
 * has the execute for when a back command is called
 *     peeks the first parameter in the stack
 *     moves the turtle that distance back
 *
 * @author kelly
 *
 */
public class Backward extends TurtleCommands {
	
	public Backward(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		currentTurtle.move(-1*expr1);
		return expr1;
	}
	
	@Override
	protected void addReturn(double returnVal) {
		//do nothing
	}
}