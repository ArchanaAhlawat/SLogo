package backend.commands.turtleCommands.oneParam;

import backend.Stacks;
import backend.Turtle;
import backend.commands.turtleCommands.TurtleCommandsOneParam;

/**
 * has the execute for when a forward command is called
 *     peeks at the first parameter in the stack
 *     moves the turtle that distance forward
 *     does not need to add the distance moved forward to the stack because it was not popped (only peeked!)
 *
 * @author kelly
 * @author archana
 * 
 */
public class Forward extends TurtleCommandsOneParam {
	
	public Forward(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		currentTurtle.move(expr1);
		return expr1;
	}
}