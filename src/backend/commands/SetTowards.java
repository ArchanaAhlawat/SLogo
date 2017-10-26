package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

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
public class SetTowards implements Command {
	
	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double currentAngle = currentTurtle.getAbsoluteOrientation("theta");
		double newAngle = currentTurtle.angle(instructionStacks.popDouble(), instructionStacks.popDouble());
		currentTurtle.setHeading(newAngle);
		instructionStacks.addDouble(newAngle - currentAngle);
	}
}