package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * @author kelly
 * has the execute for when a heading command is called
 *     doesn't need any parameters from the stack
 *     asks the turtle for the heading value
 *     pushes if the angle (heading) of the turtle facing to the stack
 *     returns the stack of parameters
 *
 */
public class Heading implements Command {
	
	private static final String HEADING = "theta";
	
	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		vars.push(currentTurtle.getAbsoluteOrientation(HEADING));
		return vars;
	}
}