package backend.commands.turtleCommands;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;

/**
 * has the execute for when a setheading command is called
 *     pops the parameter needed off the stack to be used to set the angle
 *     makes the turtle rotate to that absolute location
 *     pushes the number of degrees rotated to the stack
 *
 * @author kelly
 *
 */
public class SetHeading extends TurtleCommandsOneParam {

	public SetHeading(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	protected double doUpdate() {
		return currentTurtle.setHeading(expr1);
	}
}

