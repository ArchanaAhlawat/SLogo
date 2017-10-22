package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * @author kelly
 * has the execute for when a setheading command is called
 *     pops the parameter needed off the stack to be used to set the angle
 *     makes the turtle rotate to that absolute location
 *     pushes the number of degrees rotated to the stack
 *     returns the stack of parameters
 *
 */
public class SetHeading implements Command {

	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		currentTurtle.setHeading(vars.peek());
		return vars;
	}
}
