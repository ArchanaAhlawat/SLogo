package backend.commands.turtleCommands.twoParams;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;
import backend.commands.turtleCommands.TurtleCommands;

/**
 * has the execute for when a settowards command is called
 *     pops the two parameters needed off the stack to be used to set the angle
 *     makes the turtle rotate to that angle calculated from the position popped
 *     pushes the number of degrees rotated to the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class SetTowards extends TurtleCommands {
	
	public SetTowards(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		double currentAngle = currentTurtle.getAbsoluteOrientation("theta");
		double newAngle = currentTurtle.angle(expr1, expr2);
		currentTurtle.setHeading(newAngle);
		return newAngle - currentAngle;
	}
}