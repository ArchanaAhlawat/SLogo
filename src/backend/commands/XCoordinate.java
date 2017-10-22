package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * @author kelly
 * has the execute for when a xcor command is called
 *     doesn't need any parameter from the stack
 *     asks the turtle for its xcor value
 *     pushes if the turtle's xcor to the stack
 *     returns the stack of parameters
 *
 */
public class XCoordinate implements Command {
	
	private static final String XCOR = "xcor";
	
	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		vars.push(currentTurtle.getAbsoluteOrientation(XCOR));
		return vars;
	}
}