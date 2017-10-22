package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * @author kelly
 * has the execute for when a ispendown command is called
 *     doesn't need any parameters from the stack
 *     asks the turtle for the pendown value
 *     pushes if the pen is up or down to the stack
 *     returns the stack of parameters
 *
 */
public class IsPenDown implements Command {
	
	private static final String ISPENDOWN = "penDown";
	
	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		vars.push(currentTurtle.getAbsoluteOrientation(ISPENDOWN));
		return vars;
	}
}