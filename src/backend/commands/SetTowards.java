package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * @author kelly
 * has the execute for when a settowards command is called
 *     pops the two parameters needed off the stack to be used to set the angle
 *     makes the turtle rotate to that angle calculated from the position popped
 *     pushes the number of degrees rotated to the stack
 *     returns the stack of parameters
 *
 */
public class SetTowards implements Command {
	
	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		double currentAngle = currentTurtle.getAbsoluteOrientation("theta");
		double newAngle = currentTurtle.angle(vars.pop(), vars.pop());
		currentTurtle.setHeading(newAngle);
		vars.push(newAngle - currentAngle);
		return vars;
	}
}